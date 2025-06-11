package com.csc340.security_demo_basic.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Service;

@Service
public class AppUserDetailsService implements UserDetailsService {

  PasswordEncoder passwordEncoder;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

    return userDetailsService().loadUserByUsername(username);
  }

  public UserDetailsService userDetailsService() {
    // InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
    // manager.createUser(
    // User.withUsername("anakin")
    // .password(this.passwordEncoder.encode("no-sand"))
    // .roles("PADAWAN").build());

    // manager.createUser(
    // User.withUsername("obiwan")
    // .password(this.passwordEncoder.encode("hello-there"))
    // .roles("KNIGHT").build());

    // manager.createUser(
    // User.withUsername("quigon")
    // .password(this.passwordEncoder.encode("bigger-fish"))
    // .roles("MASTER").build());

    UserDetails user = User.builder()
        .username("anakin")
        .password(passwordEncoder().encode("no-sand"))
        .roles("PADAWAN")
        .build();

    UserDetails mod = User.builder()
        .username("obiwan")
        .password(passwordEncoder().encode("hello-there"))
        .roles("KNIGHT")
        .build();

    UserDetails admin = User.builder()
        .username("quigon")
        .password(passwordEncoder().encode("bigger-fish"))
        .roles("MASTER")
        .build();

    return new InMemoryUserDetailsManager(user, mod, admin);
    // return manager;

  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

}
