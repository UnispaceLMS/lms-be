package com.unispace.lms.dto.student;

import com.unispace.lms.enums.Program;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentRequest {
    private Integer teacherId;

    private String email;

    private String firstName;

    private String lastName;

    private Instant dateOfBirth;

    private String phoneNumber;

    private Program program;

    private String year;

    private Integer expectedGraduation;

    private List<String> allergies;

    private String primaryDiagnosis;

    private String emergencyContactName;

    private String emergencyContactPhoneNumber;

    private String emergencyContactEmail;
}
