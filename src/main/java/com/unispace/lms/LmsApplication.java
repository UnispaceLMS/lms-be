package com.unispace.lms;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition
@SpringBootApplication
public class LmsApplication {

  public static void main(String[] args) {
    SpringApplication.run(LmsApplication.class, args);
  }
}
