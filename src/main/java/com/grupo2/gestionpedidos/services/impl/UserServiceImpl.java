package com.grupo2.gestionpedidos.services.impl;

import com.grupo2.gestionpedidos.dtos.request.UserRequest;
import com.grupo2.gestionpedidos.dtos.response.UserResponse;
import com.grupo2.gestionpedidos.entities.Role;
import com.grupo2.gestionpedidos.entities.User;
import com.grupo2.gestionpedidos.mappers.RoleMapper;
import com.grupo2.gestionpedidos.mappers.UserMapper;
import com.grupo2.gestionpedidos.repositories.RoleRepository;
import com.grupo2.gestionpedidos.repositories.UserRepository;
import com.grupo2.gestionpedidos.services.UserService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final UserMapper userMapper;


    @Override
    public UserResponse findById(Long id) {
        return userRepository.findById(id)
                .map(userMapper::userToUserResponse)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
    }

    @Override
    public UserResponse save(UserRequest userRequest) {
        return Optional.of(userRequest)
                .map(userMapper::userRequestToUser)
                .map(user -> {
                    List<Role> roles = new ArrayList<>();
                    roles.add(roleRepository.findByName("ROLE_USER"));

                    if (userRequest.isAdmin()) {
                        roles.add(roleRepository.findByName("ROLE_ADMIN"));
                    }

                    user.setRoles(roles);
                    user.setPassword(passwordEncoder.encode(userRequest.getPassword()));
                    return userRepository.save(user);
                })
                .map(user -> {
                    UserResponse response = userMapper.userToUserResponse(user);
                    response.setRoles(userMapper.rolesToRoleResponses(user.getRoles()));
                    return response;
                })
                .orElseThrow();
    }

    @Override
    public UserResponse findByEmail(String email) {
        User user = userRepository.findByEmail(email).orElseThrow(() -> new EntityNotFoundException("User not found"));
        return userMapper.userToUserResponse(user);
    }

    @Override
    public UserResponse update(UserRequest userRequest, Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));

        user.setName(userRequest.getName());
        user.setEmail(userRequest.getEmail());
        user.setPassword(passwordEncoder.encode(userRequest.getPassword()));

        User updatedUser = userRepository.save(user);
        return userMapper.userToUserResponse(updatedUser);
    }

    @Override
    public void delete(Long id){
        User user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
        userRepository.delete(user);
    }
}
