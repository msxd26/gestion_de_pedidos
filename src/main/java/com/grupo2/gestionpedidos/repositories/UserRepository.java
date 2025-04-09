package com.grupo2.gestionpedidos.repositories;

import com.grupo2.gestionpedidos.entities.User;

import java.util.Optional;

public interface UserRepository extends GenericRepository<User, Long> {

    Boolean existsByEmail(String email);

    Optional<User> findByEmail(String email);
}
