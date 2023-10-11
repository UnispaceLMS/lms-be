package com.unispace.lms.service;

import com.unispace.lms.dto.user.UserRequest;

public interface UserService {

  UserRequest create(UserRequest userRequest);

  UserRequest update(UserRequest request);

  UserRequest fetch(String email);
}
