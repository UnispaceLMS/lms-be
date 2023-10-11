package com.unispace.lms.service.impl;

import com.unispace.lms.dto.user.UserRequest;
import com.unispace.lms.enums.Role;
import com.unispace.lms.mapper.UserMapper;
import com.unispace.lms.model.User;
import com.unispace.lms.repository.UserRepository;
import com.unispace.lms.service.UserService;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
  @Autowired private UserRepository userRepository;
  @Autowired private UserMapper userMapper;
  @Autowired private BCryptPasswordEncoder bCryptPasswordEncoder;

  @Override
  public UserRequest create(UserRequest request) {
    Optional<User> existing = userRepository.findByEmail(request.getEmail());
    if (request.getRole() == Role.ADMIN || existing.isPresent()) {
      return null;
    }
    request.setPassword(bCryptPasswordEncoder.encode(request.getPassword()));
    return userMapper.mapEntityToResponse(
        userRepository.save(userMapper.mapRequestToEntity(request)));
  }

  @Override
  public UserRequest update(UserRequest request) {
    Optional<User> existing = userRepository.findByEmail(request.getEmail());
    if (existing.isEmpty()) {
      return null;
    }
    if (StringUtils.isNotBlank(request.getPassword())) {
      request.setPassword(bCryptPasswordEncoder.encode(request.getPassword()));
    }
    User toPersist = userMapper.mapRequestToEntity(request);
    toPersist.setId(existing.get().getId());
    return userMapper.mapEntityToResponse(userRepository.save(toPersist));
  }

  @Override
  public UserRequest fetch(String email) {
    Optional<User> userOptional = userRepository.findByEmail(email);
    return userOptional.map(user -> userMapper.mapEntityToResponse(user)).orElse(null);
  }
}
