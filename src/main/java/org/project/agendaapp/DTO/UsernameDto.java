package org.project.agendaapp.DTO;

import jakarta.validation.constraints.NotBlank;

public class UsernameDto {
    @NotBlank(message = "new username is mandatory")
    private String newUserName;
}
