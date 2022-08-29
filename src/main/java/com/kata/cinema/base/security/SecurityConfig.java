package com.kata.cinema.base.security;

import com.kata.cinema.base.security.filter.TokenAuthenticationFilter;
import com.kata.cinema.base.security.jwt.JwtUserProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private UserDetailsService userDetailsService;

    private final JwtUserProvider jwtUserProvider;


    @Autowired
    public SecurityConfig(JwtUserProvider jwtUserProvider, UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
        this.jwtUserProvider = jwtUserProvider;
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests().anyRequest().permitAll();
        http.authorizeRequests();
//                .antMatchers("/login").permitAll()
//                .antMatchers("/token").permitAll()
//                .anyRequest()
//                .authenticated()
//                .and().formLogin()
//                .usernameParameter("email")
//                .and().httpBasic();
        http.addFilter(new TokenAuthenticationFilter(authenticationManagerBean(), jwtUserProvider));

    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }



    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
