package com.unispace.lms.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;

@Getter
public enum GoalCategory {
    HEALTH_WELLNESS("Health & Wellness"),
    SAFETY("Safety"),
    PERSONAL_MANAGEMENT("Personal Management"),
    HEALTHY_RELATIONSHIPS("Healthy Relationships"),
    HOME_MANAGEMENT("Home Management"),
    EMPLOYMENT("Employment"),
    MONEY_MANAGEMENT("Money Management"),
    TRANSPORTATION("Transportation"),
    MISCELLANEOUS("Miscellaneous");

    private final String value;

    GoalCategory(String value) {
        this.value = value;
    }

    @JsonCreator
    public static GoalCategory fromValue(String text) {
        for (GoalCategory g : GoalCategory.values()) {
            if (g.value.equalsIgnoreCase(text) || g.name().equalsIgnoreCase(text)) {
                return g;
            }
        }
        return null;
    }
}
