package com.berkai.spring_security_basic_auth.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter @Setter
@Entity
@Table(name = "users")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User  {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(unique = true,nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;

    @ElementCollection(targetClass = Role.class , fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles" ,joinColumns = @JoinColumn( name = "user_id"))
    @Column(name = "role" , nullable = false)
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;

    // Hesap durumu
    private boolean accountNonExpired = true;
    private boolean accountNonLocked = true;
    private boolean credentialsNonExpired = true;
    private boolean enabled = true;
}
