package com.unispace.lms.model;

import com.unispace.lms.enums.StrengthOrConcernType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "strength_concern")
public class StrengthAndConcern {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Integer studentId;

    private StrengthOrConcernType type;

    private String note;
}
