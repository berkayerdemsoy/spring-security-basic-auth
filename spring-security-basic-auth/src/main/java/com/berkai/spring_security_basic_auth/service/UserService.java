package com.berkai.spring_security_basic_auth.service;


import com.berkai.spring_security_basic_auth.dto.CreateUserRequest;
import com.berkai.spring_security_basic_auth.model.Role;
import com.berkai.spring_security_basic_auth.model.User;
import com.berkai.spring_security_basic_auth.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public User createUser(CreateUserRequest request){
       User user = User.builder()
               .name(request.name())
               .username(request.username())
               .password(passwordEncoder.encode(request.password()))
               .roles(Set.of(Role.USER))
               .accountNonExpired(true)
               .accountNonLocked(true)
               .credentialsNonExpired(true)
               .enabled(true)
               .build();
       return userRepository.save(user);
    }


}
