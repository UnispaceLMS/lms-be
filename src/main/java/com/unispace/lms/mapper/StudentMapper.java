package com.unispace.lms.mapper;

import com.unispace.lms.dto.student.StudentRequest;
import com.unispace.lms.model.Student;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    StudentRequest mapEntityToResponse(Student student);

    Student mapRequestToEntity(StudentRequest studentRequest);
}
