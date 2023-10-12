package com.unispace.lms.controller;

import com.unispace.lms.auth.JwtUtil;
import com.unispace.lms.constant.AuthConstants;
import com.unispace.lms.dto.auth.LoginRequest;
import com.unispace.lms.dto.user.UserRequest;
import com.unispace.lms.mapper.UserMapper;
import com.unispace.lms.model.User;
import com.unispace.lms.model.auth.SecurityUser;
import com.unispace.lms.service.UserService;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Objects;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1.0/auth")
public class AuthController {

  @Autowired private AuthenticationManager authenticationManager;
  @Autowired private UserService userService;
  @Autowired private JwtUtil jwtUtil;
  @Autowired private UserMapper userMapper;

  @PostMapping("/login")
  public ResponseEntity<UserRequest> login(
      @RequestBody LoginRequest loginRequest, HttpServletResponse servletResponse) {
    Authentication authentication =
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                loginRequest.getEmail(), loginRequest.getPassword()));
    String email = authentication.getName();
    User user = User.builder().email(email).build();
    String token = jwtUtil.createToken(user);
    if (Objects.nonNull(authentication.getPrincipal())) {
      SecurityUser securityUser = (SecurityUser) authentication.getPrincipal();
      if (Objects.nonNull(securityUser) && Objects.nonNull(securityUser.getUser())) {
        user = securityUser.getUser();
      }
    }
    UserRequest response = userMapper.mapEntityToResponse(user);
    SecurityContextHolder.getContext().setAuthentication(authentication);
    servletResponse.setHeader("x-access-token", token);
    return ResponseEntity.ok(response);
  }

  @PostMapping("/signup")
  public ResponseEntity<UserRequest> signup(@RequestBody UserRequest userRequest) {
    UserRequest response = userService.create(userRequest);
    if (Objects.isNull(response)) {
      return ResponseEntity.badRequest().body(null);
    }
    return ResponseEntity.status(HttpStatus.CREATED).body(response);
  }

  @GetMapping("/validate")
  public ResponseEntity<UserRequest> validateToken(@RequestHeader("Authorization") String jwt) {
    if (StringUtils.isNotBlank(jwt) && jwt.startsWith(AuthConstants.TOKEN_PREFIX)) {
      jwt = jwt.substring(AuthConstants.TOKEN_PREFIX.length());
    } else {
      return ResponseEntity.badRequest().body(null);
    }
    Claims claims = jwtUtil.parseJwtClaims(jwt);
    UserRequest userRequest = new UserRequest();
    if (jwtUtil.validateClaims(claims)) {
      userRequest = userService.fetch(claims.getSubject());
    }
    return ResponseEntity.ok(userRequest);
  }
}
