package com.example.carssale.service.Impl;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class CarsSaleUser extends User {

    private String clientName;

    public CarsSaleUser(String username, String password, Collection<? extends GrantedAuthority> authorities, String clientName) {
        super(username, password, authorities);
        this.clientName = clientName;
    }

    public CarsSaleUser(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
    }

    public String getUserIdentifierEmail() {
        return this.getUsername();
    }

    public String getClientName() {
        return this.clientName;
    }
}
