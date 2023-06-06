package com.contacts.app.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig{

	@Bean
	  SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	    return http
	      .authorizeRequests((requests) -> requests.mvcMatchers("/v1/cms/contacts").authenticated())
	      .oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt) 
	      .build();
	  }
}
