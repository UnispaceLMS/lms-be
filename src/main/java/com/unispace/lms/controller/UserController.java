package com.unispace.lms.controller;

import com.unispace.lms.dto.user.UserRequest;
import com.unispace.lms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1.0/user")
public class UserController {

  @Autowired private UserService userService;

  @PostMapping(
      value = "/update",
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<UserRequest> update(@RequestBody UserRequest userRequest) {
    return ResponseEntity.status(HttpStatus.CREATED).body(userService.update(userRequest));
  }

  @GetMapping(value = "/fetch", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<UserRequest> fetch(@RequestHeader("email") String email) {
    return ResponseEntity.ok(userService.fetch(email));
  }
}
