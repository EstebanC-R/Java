package com.milton.gestionar_usuario.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserDTO {
    private Long id;
    private String fullName;
    private Integer age;
    private String email;
    private int totalOrdenes;

}
