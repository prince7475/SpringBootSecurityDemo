package com.princedonkor.security.springsecurityexample.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("prince").password("test").roles("USER").and()
                .withUser("demo").password("test2").roles("ADMIN");
    }


    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception{
        httpSecurity
                .authorizeRequests()
//                .antMatchers("**//rest/*") -- this is done if you want to match particular urls
                .anyRequest()
                .fullyAuthenticated()
                .and().httpBasic();
            httpSecurity.csrf().disable();

    }

}
