package com.boots.config;

import com.boots.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    UserService userService;
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception{
        httpSecurity
                .csrf()
                .disable()
                .authorizeRequests()
                    //                access only for non registered users
                    .antMatchers("/registration").not().fullyAuthenticated()
                    //                access only for users with admin rights
                    .antMatchers("/admin/**").hasRole("ADMIN")
                    //                access only for with users access
                    .antMatchers("/news").hasRole("USER")
                    //                Access for all the users
                    .antMatchers("/", "/resorces/**").permitAll()
                    //                All other pages require authentications
                .anyRequest().authenticated()
                .and()
//                configuration for enter in system
                .formLogin()
                .loginPage("/login")
//                forwarding on main page
                .defaultSuccessUrl("/")
                .permitAll()
                .and()
                .logout()
                .permitAll()
                .logoutSuccessUrl("/");
    }

    @Autowired
    protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(userService).passwordEncoder(bCryptPasswordEncoder());
    }
}
