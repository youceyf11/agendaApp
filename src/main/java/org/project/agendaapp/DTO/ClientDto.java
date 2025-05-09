package org.project.agendaapp.DTO;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ClientDto {
    private Long id;
    private String nom;
    private String prenom;
    private String email;
    private String telephone;
    private FicheClientDto fiche;

}