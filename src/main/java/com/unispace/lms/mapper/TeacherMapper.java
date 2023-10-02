package com.unispace.lms.mapper;

import com.unispace.lms.dto.teacher.TeacherRequest;
import com.unispace.lms.model.Teacher;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TeacherMapper {
    TeacherRequest mapEntityToResponse(Teacher teacher);

    Teacher mapRequestToEntity(TeacherRequest teacherRequest);
}
