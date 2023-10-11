package com.unispace.lms.service.impl;

import com.unispace.lms.model.auth.SecurityUser;
import com.unispace.lms.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class LmsUserDetailsService implements UserDetailsService {

  private final UserRepository userRepository;

  public LmsUserDetailsService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    return userRepository
        .findByEmail(username)
        .map(SecurityUser::new)
        .orElseThrow(() -> new UsernameNotFoundException("Email not registered"));
  }
}
