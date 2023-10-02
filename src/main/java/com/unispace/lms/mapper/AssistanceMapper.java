package com.unispace.lms.mapper;

import com.unispace.lms.dto.student.AssistanceRequest;
import com.unispace.lms.model.Assistance;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AssistanceMapper {
  AssistanceRequest mapEntityToResponse(Assistance assistance);

  Assistance mapRequestToEntity(AssistanceRequest assistanceRequest);
}
