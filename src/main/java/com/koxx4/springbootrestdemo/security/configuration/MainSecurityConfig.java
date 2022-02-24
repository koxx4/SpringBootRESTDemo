package com.koxx4.springbootrestdemo.security.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

import javax.sql.DataSource;

@Configuration
public class MainSecurityConfig {

    @Value("${admin.pass}")
    CharSequence adminPassword;

    @Bean
    public UserDetailsService userDetailsService(@Autowired DataSource dataSource){
        JdbcUserDetailsManager userDetailsManager = new JdbcUserDetailsManager(dataSource);
        userDetailsManager.setUsersByUsernameQuery("SELECT nickname,password,enabled FROM appUser" +
                " WHERE nickname = ?");
        userDetailsManager.setAuthoritiesByUsernameQuery("SELECT nickname,authority FROM authorities" +
                " WHERE nickname = ?");
        userDetailsManager.setCreateUserSql("INSERT INTO appUser(nickname,password,enabled) VALUES " +
                "(?,?,?)");
        userDetailsManager.setCreateAuthoritySql("INSERT INTO authorities (nickname,authority) VALUES (?,?)");

        userDetailsManager.createUser(User.withUsername("koxx4")
                .password(passwordEncoder().encode(adminPassword))
                .roles("ADMIN").build());

        return userDetailsManager;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new SCryptPasswordEncoder();
    }

}
