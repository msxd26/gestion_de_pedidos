package com.grupo2.gestionpedidos.services.impl;

import com.grupo2.gestionpedidos.dtos.response.UserResponse;
import com.grupo2.gestionpedidos.mappers.UserMapper;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class JpaUserDetailsService implements UserDetailsService {

    private final UserServiceImpl userServiceImpl;
    private final UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        UserResponse userResponse = userServiceImpl.findByEmail(email);


        if (userMapper == null) {
            throw new UsernameNotFoundException(String.format("Usuario %s no existe en el sistema", email));
        }

        List<GrantedAuthority> authorities = userResponse.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getNameRole()))
                .collect(Collectors.toList());
        return new User(userResponse.getEmail(), userResponse.getPassword(), authorities);
    }
}
