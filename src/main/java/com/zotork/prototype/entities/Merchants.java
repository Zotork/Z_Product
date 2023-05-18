package com.zotork.prototype.entities;

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

import static java.util.Arrays.stream;
@Entity
@Data
@AllArgsConstructor
@Builder
public class Merchants implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long merchantId;

    @Column(nullable = false, unique=true)
    private String merchantName;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String merchantType;

    @Column(nullable=false)
    private int businessSize;

    @Column(nullable = false)
    private String mobileNumber;

    private String businessName;

    @Enumerated(EnumType.STRING)
    private MerchantRoles merchantRoles;

    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return stream(this.merchantRoles.getAuthorities()).map(SimpleGrantedAuthority::new).collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.merchantName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
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
