package com.unispace.lms.mapper;

import com.unispace.lms.dto.user.UserRequest;
import com.unispace.lms.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {
  @Mapping(target = "password", ignore = true)
  UserRequest mapEntityToResponse(User user);

  User mapRequestToEntity(UserRequest userRequest);
}
