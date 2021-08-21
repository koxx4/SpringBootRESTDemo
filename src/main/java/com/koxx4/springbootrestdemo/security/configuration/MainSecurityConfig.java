package com.koxx4.springbootrestdemo.security.configuration;

import org.springframework.beans.factory.annotation.Autowired;
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

    @Bean
    public UserDetailsService userDetailsService(@Autowired DataSource dataSource){
        JdbcUserDetailsManager userDetailsManager = new JdbcUserDetailsManager(dataSource);
        userDetailsManager.setUsersByUsernameQuery("SELECT nick_name,password,enabled FROM AppUsers" +
                " WHERE nick_name = ?");
        userDetailsManager.setAuthoritiesByUsernameQuery("SELECT nick_name,authority FROM authorities" +
                " WHERE nick_name = ?");
        userDetailsManager.setCreateUserSql("INSERT INTO AppUsers(nick_name,password,enabled) VALUES " +
                "(?,?,?)");
        userDetailsManager.setCreateAuthoritySql("INSERT INTO authorities (nick_name,authority) VALUES (?,?)");

        userDetailsManager.createUser(User.withUsername("koxx4")
                .password(passwordEncoder().encode("zemir555"))
                .roles("ADMIN").build());

        return userDetailsManager;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new SCryptPasswordEncoder();
    }

}
