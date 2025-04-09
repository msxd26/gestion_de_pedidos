package com.grupo2.gestionpedidos.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleResponse {

    private Long idRole;

    private String nameRole;

    private String descriptionRole;
}
