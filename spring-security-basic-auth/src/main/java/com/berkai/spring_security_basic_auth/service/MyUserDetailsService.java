package com.berkai.spring_security_basic_auth.service;

import com.berkai.spring_security_basic_auth.model.User;
import com.berkai.spring_security_basic_auth.model.UserPrincipal;
import com.berkai.spring_security_basic_auth.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username).orElseThrow(() ->
                new UsernameNotFoundException("User Not Found"));
        return new UserPrincipal(user);
    }
}
