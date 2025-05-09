package org.project.agendaapp.DTO;


import lombok.*;
import lombok.experimental.SuperBuilder;
import org.project.agendaapp.Enum.Role;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder
public class UserDto {

    private Long id;
    private String username;
    private String password;
    private Role role;

}
