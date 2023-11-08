package com.unispace.lms.model.student;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class Support {
    private String supportAndModificationToEnv;

    private String condition;

    private String Location;
}
