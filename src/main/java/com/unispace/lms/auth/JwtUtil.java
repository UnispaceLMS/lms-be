package com.unispace.lms.auth;

import com.unispace.lms.constant.AuthConstants;
import com.unispace.lms.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class JwtUtil {
  // todo: shift to vault
  private final String secret_key = "mysecretkey";
  private long accessTokenValidity = 1440; // 1 day

  private final JwtParser jwtParser;

  public JwtUtil() {
    this.jwtParser = Jwts.parser().setSigningKey(secret_key);
  }

  public String createToken(User user) {
    Claims claims = Jwts.claims().setSubject(user.getEmail());
    claims.put("firstName", user.getFirstName());
    claims.put("lastName", user.getLastName());
    Date tokenCreateTime = new Date();
    Date tokenValidity =
        new Date(tokenCreateTime.getTime() + TimeUnit.MINUTES.toMillis(accessTokenValidity));
    return Jwts.builder()
        .setClaims(claims)
        .setExpiration(tokenValidity)
        .signWith(SignatureAlgorithm.HS256, secret_key)
        .compact();
  }

  public Claims resolveClaims(HttpServletRequest req) {
    try {
      String token = resolveToken(req);
      if (token != null) {
        return parseJwtClaims(token);
      }
      return null;
    } catch (ExpiredJwtException ex) {
      req.setAttribute("expired", ex.getMessage());
      throw ex;
    } catch (Exception ex) {
      req.setAttribute("invalid", ex.getMessage());
      throw ex;
    }
  }

  public String resolveToken(HttpServletRequest request) {

    String bearerToken = request.getHeader(AuthConstants.TOKEN_HEADER);
    if (bearerToken != null && bearerToken.startsWith(AuthConstants.TOKEN_PREFIX)) {
      return bearerToken.substring(AuthConstants.TOKEN_PREFIX.length());
    }
    return null;
  }

  public boolean validateClaims(Claims claims) throws AuthenticationException {
    return Objects.nonNull(claims) && claims.getExpiration().after(new Date());
  }

  public String getEmail(Claims claims) {
    return claims.getSubject();
  }

  public Claims parseJwtClaims(String token) {
    return jwtParser.parseClaimsJws(token).getBody();
  }

  private List<String> getRoles(Claims claims) {
    return (List<String>) claims.get("roles");
  }

  public static Integer extractOwnerUserIdFromJwt() {
    Integer ownerUserId = null;
    if (Objects.nonNull(SecurityContextHolder.getContext().getAuthentication())
        && Objects.nonNull(SecurityContextHolder.getContext().getAuthentication().getPrincipal())) {
      User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
      if (Objects.nonNull(user)) {
        ownerUserId = user.getId();
      }
    }
    return ownerUserId;
  }
}
