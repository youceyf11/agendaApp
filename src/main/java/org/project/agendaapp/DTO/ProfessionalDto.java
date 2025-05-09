package org.project.agendaapp.DTO;


import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProfessionalDto {
    private Long id;
    private String nom;
    private String prenom;
    private String specialite;
    private String email;
}
