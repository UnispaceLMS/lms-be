package com.unispace.lms.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;

@Getter
public enum BloodGroup {
  A_POSITIVE("A+"),
  B_POSITIVE("B+"),
  O_POSITIVE("O+"),
  AB_POSITIVE("AB+"),
  A_NEGATIVE("A-"),
  B_NEGATIVE("B-"),
  AB_NEGATIVE("AB-"),
  O_NEGATIVE("O-");

  private final String value;

  BloodGroup(String value) {
    this.value = value;
  }

  @JsonCreator
  public static BloodGroup fromValue(String text) {
    for (BloodGroup b : BloodGroup.values()) {
      if (b.value.equalsIgnoreCase(text) || b.name().equalsIgnoreCase(text)) {
        return b;
      }
    }
    return null;
  }
}
