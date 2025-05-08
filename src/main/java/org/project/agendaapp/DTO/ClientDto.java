package org.project.agendaapp.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClientDto {
    private Long id;
    private String nom;
    private String prenom;
    private String email;
    private String telephone;
    private FicheClientDto fiche;

}