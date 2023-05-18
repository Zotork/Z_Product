package com.zotork.prototype.entities;

import static java.util.Arrays.stream;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Consumer implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long consumerId;

    @Column(nullable = false, unique = true)
    private String consumerName;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private Long mobileNumber;

    @Column(nullable = false)
    private String prefferedUsername;
    
    @Enumerated(EnumType.STRING)
    private ConsumerRoles role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
     return stream(this.role.getAuthourities()).map(SimpleGrantedAuthority::new).collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.consumerName;
    }

    @Override
    public boolean isAccountNonExpired() {
       return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    

    @Override
    public boolean isEnabled() {
        return true;
    }
    
    
}
