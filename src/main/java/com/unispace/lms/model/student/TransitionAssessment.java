package com.unispace.lms.model.student;


import com.unispace.lms.enums.GoalCategory;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class TransitionAssessment {
    @Enumerated(EnumType.STRING)
    private GoalCategory type;

    private Integer score;
}
