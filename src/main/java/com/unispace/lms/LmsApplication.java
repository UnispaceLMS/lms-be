package com.unispace.lms;

import com.unispace.lms.enums.Role;
import com.unispace.lms.model.User;
import com.unispace.lms.repository.UserRepository;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@OpenAPIDefinition
@SpringBootApplication
public class LmsApplication {

  public static void main(String[] args) {
    SpringApplication.run(LmsApplication.class, args);
  }

//  @Bean
//  CommandLineRunner commandLineRunner(UserRepository users, BCryptPasswordEncoder encoder) {
//    return args -> {
//      users.save(new User(1, "s@gmail.com", "s", "b", "123", Role.ADMIN, encoder.encode("abcd")));
//    };
//  }
}
