package com.example.carssale.service.Impl;

import com.example.carssale.model.entity.UserEntity;
import com.example.carssale.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarsSaleUserServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    public CarsSaleUserServiceImpl(UserRepository userRepository) {

        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        System.out.println(email + " " + "-----------------------------------------");
        UserEntity userEntity = userRepository
                .findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User with that email " + email + " not found!"));
        return mapToUserDetails(userEntity);
    }

    private UserDetails mapToUserDetails(UserEntity user) {

        List<GrantedAuthority> authorities = user
                .getRole()
                .stream()
                .map(r -> new SimpleGrantedAuthority("ROLE_" + r.getRole().name()))
                .collect(Collectors.toList());


        return new CarsSaleUser(
                user.getEmail(),
                user.getPassword(),
                authorities
        );
    }
}
