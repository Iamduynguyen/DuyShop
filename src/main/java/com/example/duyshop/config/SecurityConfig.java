package com.example.duyshop.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.List;

import static org.springframework.http.HttpMethod.GET;

@Configuration
@EnableWebSecurity

public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    Authen authen;
//    private final CorsFilter corsFilter;


    @Bean
    public BCryptPasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(authen).passwordEncoder(encoder());
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf().disable().cors().disable();
//        httpSecurity.authorizeRequests().antMatchers(GET,"/api/**","/admin/**", "/Adminform/**").hasRole("ADMIN")
//                .antMatchers("/checkout/**", "/cart/**", "/order").hasAnyRole("USER").antMatchers().authenticated()
//                .anyRequest().permitAll();
//        httpSecurity.authorizeRequests().and().formLogin()
//                .loginProcessingUrl("/j_spring_security_check")
//                .loginPage("/sign")
//                .defaultSuccessUrl("/")
//                .failureUrl("/sign?status=login_false")
//                .usernameParameter("username")
//                .passwordParameter("password");


    }

}
