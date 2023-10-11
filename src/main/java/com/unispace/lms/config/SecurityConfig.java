package com.unispace.lms.config;

import com.unispace.lms.auth.JwtAuthenticationFilter;
import com.unispace.lms.service.impl.LmsUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
  private final LmsUserDetailsService lmsUserDetailsService;
  private final JwtAuthenticationFilter jwtAuthenticationFilter;

  public SecurityConfig(
      LmsUserDetailsService lmsUserDetailsService,
      JwtAuthenticationFilter jwtAuthenticationFilter) {
    this.lmsUserDetailsService = lmsUserDetailsService;
    this.jwtAuthenticationFilter = jwtAuthenticationFilter;
  }

  @Bean
  SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    return http.authorizeHttpRequests(
            auth ->
                auth.requestMatchers(AntPathRequestMatcher.antMatcher("/v1.0/auth/**"))
                    .permitAll()
                    .requestMatchers("swagger-ui/**")
                    .permitAll()
                    .requestMatchers("/auth/**")
                    .permitAll()
                    .anyRequest()
                    .authenticated())
        .headers(
            httpSecurityHeadersConfigurer ->
                httpSecurityHeadersConfigurer.frameOptions(
                    HeadersConfigurer.FrameOptionsConfig::sameOrigin))
        .userDetailsService(lmsUserDetailsService)
        .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
        .build();
  }

  //  @Bean
  //  public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration)
  //      throws Exception {
  //    return configuration.getAuthenticationManager();
  //  }

  @Bean
  public AuthenticationManager authenticationManager(
      HttpSecurity http, BCryptPasswordEncoder bCryptPasswordEncoder) throws Exception {
    AuthenticationManagerBuilder authenticationManagerBuilder =
        http.getSharedObject(AuthenticationManagerBuilder.class);
    authenticationManagerBuilder
        .userDetailsService(lmsUserDetailsService)
        .passwordEncoder(bCryptPasswordEncoder);
    return authenticationManagerBuilder.build();
  }

  @Bean
  public BCryptPasswordEncoder bCryptPasswordEncoder() {
    return new BCryptPasswordEncoder();
  }
}
