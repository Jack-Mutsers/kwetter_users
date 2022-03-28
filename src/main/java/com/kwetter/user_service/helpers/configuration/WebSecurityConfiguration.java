package com.kwetter.user_service.helpers.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
       http.csrf().disable().authorizeRequests()
        .antMatchers("/").permitAll()
        .antMatchers(HttpMethod.POST,"/user/register").permitAll()
        .antMatchers(HttpMethod.PUT,"/user/").permitAll()
        .antMatchers(HttpMethod.DELETE, "/user/").permitAll()
        .antMatchers(HttpMethod.GET,"/user/").permitAll()
        .anyRequest().authenticated();
    }
}