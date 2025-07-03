package com.berkai.spring_security_basic_auth.config;

import com.berkai.spring_security_basic_auth.model.Role;
import com.berkai.spring_security_basic_auth.model.User;
import com.berkai.spring_security_basic_auth.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) {
        if (userRepository.findByUsername("admin").isEmpty()) {
            User admin = User.builder()
                    .name("Admin User")
                    .username("admin")
                    .password(passwordEncoder.encode("admin123"))
                    .roles(Set.of(Role.ADMIN))
                    .accountNonExpired(true)
                    .accountNonLocked(true)
                    .credentialsNonExpired(true)
                    .enabled(true)
                    .build();

            userRepository.save(admin);
            System.out.println("✅ Default admin user created: username='admin', password='admin123'");
        } else {
            System.out.println("ℹ️ Admin user already exists. Skipping DataLoader.");
        }
    }
}
