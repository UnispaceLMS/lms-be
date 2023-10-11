package com.unispace.lms.controller;

import com.unispace.lms.auth.JwtUtil;
import com.unispace.lms.dto.auth.LoginRequest;
import com.unispace.lms.dto.auth.LoginResponse;
import com.unispace.lms.dto.user.UserRequest;
import com.unispace.lms.model.User;
import com.unispace.lms.service.UserService;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1.0/auth")
public class AuthController {

  @Autowired private AuthenticationManager authenticationManager;
  @Autowired private UserService userService;
  @Autowired private JwtUtil jwtUtil;

  @PostMapping("/login")
  public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
    Authentication authentication =
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                loginRequest.getEmail(), loginRequest.getPassword()));
    String email = authentication.getName();
    User user = User.builder().email(email).build();
    String token = jwtUtil.createToken(user);
    LoginResponse loginResponse = LoginResponse.builder().email(email).token(token).build();
    SecurityContextHolder.getContext().setAuthentication(authentication);
    return ResponseEntity.ok(loginResponse);
  }

  @PostMapping("/signup")
  public ResponseEntity<UserRequest> signup(@RequestBody UserRequest userRequest) {
    UserRequest response = userService.create(userRequest);
    if (Objects.isNull(response)) {
      return ResponseEntity.badRequest().body(null);
    }
    return ResponseEntity.status(HttpStatus.CREATED).body(response);
  }
}
