package com.devsuperior.dscommerce.config.customgrant;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

@AllArgsConstructor
public class CustomUserAuthorities {

    @Getter
    private String username;

    @Getter
    private Collection<? extends GrantedAuthority> authorities;
}