package com.javeriana.web.project.Shared.Infrastructure.Security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    protected void configure(HttpSecurity http) throws Exception {
        //TODO: Activate admin-only patterns
        http.csrf().disable()
                .addFilterAfter(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/employees/login").permitAll()
                .antMatchers(HttpMethod.POST, "/employees").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT, "/employees").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST, "/properties").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT, "/properties").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST, "/properties/{propertyId}/offers").hasRole("EMPLOYEE")
                .antMatchers(HttpMethod.PUT, "/properties/{propertyId}/offers/{offerId}").hasRole("EMPLOYEE")
                .antMatchers(HttpMethod.DELETE, "/properties/{propertyId}/offers/{offerId}").hasRole("EMPLOYEE")
                .antMatchers(HttpMethod.POST, "/appointments").permitAll()
                .antMatchers(HttpMethod.POST, "/appointments/unassigned").hasRole("EMPLOYEE")
                //TODO: Add roles to endpoints
                //.antMatchers(HttpMethod.POST, "/employees/test").hasRole("ADMIN")
                //.antMatchers(HttpMethod.POST, "/employees/test").hasRole("EMPLOYEE")
                .anyRequest().authenticated();
    }

}
