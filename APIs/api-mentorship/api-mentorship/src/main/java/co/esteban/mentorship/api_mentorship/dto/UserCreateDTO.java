package co.esteban.mentorship.api_mentorship.dto;


import co.esteban.mentorship.api_mentorship.enums.UserRole;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class UserCreateDTO {

    @NotBlank(message = "El nombre es obligatorio.")
    @Size(min = 5, max = 20, message = "El número mínimo de caracteres es de 5 y el maximo es de 20.")
    private String userName;

    @NotBlank(message = "El email es obligatorio.")
    @Email
    @Size(max = 250, message = "El número maximo de caracteres del email es de 250.")
    private String userEmail;

    @NotBlank(message = "El rol es obligatorio.")
    private UserRole userRole;
}
