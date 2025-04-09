package com.grupo2.gestionpedidos.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {

    private Long id;
    private String name;
    private String email;
    private String password;
    private LocalDateTime signupDate;
    private BigDecimal totalSpent;
    private List<RoleResponse> roles;
}
