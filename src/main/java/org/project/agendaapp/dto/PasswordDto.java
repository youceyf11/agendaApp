package org.project.agendaapp.DTO;
import jakarta.validation.constraints.NotBlank;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class PasswordDto {
    @NotBlank(message = "old password is mandatory")
    private String oldPassword;

    @NotBlank(message = "new password is mandatory")
    private String newPassword;
}
