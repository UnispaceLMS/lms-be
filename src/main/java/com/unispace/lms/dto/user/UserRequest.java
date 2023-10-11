package com.unispace.lms.dto.user;

import com.unispace.lms.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {
  private String email;

  private String firstName;

  private String lastName;

  private String phoneNumber;

  private String password;

  private Role role;
}
