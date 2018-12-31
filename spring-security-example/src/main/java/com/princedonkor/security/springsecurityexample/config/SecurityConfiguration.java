package com.princedonkor.security.springsecurityexample.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception{
        httpSecurity
                .authorizeRequests()
//                .antMatchers("**//rest/*") -- this is done if you want to match particular urls
                .anyRequest()
                .permitAll()
                .and().httpBasic();
            httpSecurity.csrf().disable();

    }

}
