package com.milton.gestionar_usuario.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class OrderDTO {
    private Long id;
    private String description;
    private Long userId;
}
