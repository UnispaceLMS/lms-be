package com.unispace.lms.model;

import com.unispace.lms.enums.Program;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import java.time.Instant;
import java.util.List;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.CollectionUtils;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "student")
public class Student {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  private Integer ownerUserId;

  private String email;

  private String firstName;

  private String lastName;

  private Instant dateOfBirth;

  private String phoneNumber;

  private Program program;

  private String year;

  private Integer expectedGraduation;

  @ElementCollection private List<String> allergies;

  private String primaryDiagnosis;

  private String emergencyContactName;

  private String emergencyContactPhoneNumber;

  private String emergencyContactEmail;

  @Transient
  public static void prepareForUpsert(Student newEntity, Student existingEntity) {
    if (Objects.isNull(newEntity) || Objects.isNull(existingEntity)) {
      return;
    }
    newEntity.setId(existingEntity.getId());
    if (Objects.isNull(newEntity.getOwnerUserId())) {
      newEntity.setOwnerUserId(existingEntity.getOwnerUserId());
    }
    if (Objects.isNull(newEntity.getEmail())) {
      newEntity.setEmail(existingEntity.getEmail());
    }
    if (Objects.isNull(newEntity.getFirstName())) {
      newEntity.setFirstName(existingEntity.getFirstName());
    }
    if (Objects.isNull(newEntity.getLastName())) {
      newEntity.setLastName(existingEntity.getLastName());
    }
    if (Objects.isNull(newEntity.getDateOfBirth())) {
      newEntity.setDateOfBirth(existingEntity.getDateOfBirth());
    }
    if (Objects.isNull(newEntity.getPhoneNumber())) {
      newEntity.setPhoneNumber(existingEntity.getPhoneNumber());
    }
    if (Objects.isNull(newEntity.getProgram())) {
      newEntity.setProgram(existingEntity.getProgram());
    }
    if (Objects.isNull(newEntity.getYear())) {
      newEntity.setYear(existingEntity.getYear());
    }
    if (Objects.isNull(newEntity.getExpectedGraduation())) {
      newEntity.setExpectedGraduation(existingEntity.getExpectedGraduation());
    }
    if (CollectionUtils.isEmpty(newEntity.getAllergies())) {
      newEntity.setAllergies(existingEntity.getAllergies());
    }
    if (Objects.isNull(newEntity.getPrimaryDiagnosis())) {
      newEntity.setPrimaryDiagnosis(existingEntity.getPrimaryDiagnosis());
    }
    if (Objects.isNull(newEntity.getEmergencyContactName())) {
      newEntity.setEmergencyContactName(existingEntity.getEmergencyContactName());
    }
    if (Objects.isNull(newEntity.getEmergencyContactPhoneNumber())) {
      newEntity.setEmergencyContactPhoneNumber(existingEntity.getEmergencyContactPhoneNumber());
    }
    if (Objects.isNull(newEntity.getEmergencyContactEmail())) {
      newEntity.setEmergencyContactEmail(existingEntity.getEmergencyContactEmail());
    }
  }
}
