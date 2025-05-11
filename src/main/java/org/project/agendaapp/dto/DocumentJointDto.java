package org.project.agendaapp.DTO;

import lombok.*;

import java.time.LocalDate;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DocumentJointDto {
    private Long id;
    private String nomFichier;
    private String url;
    private String typeFichier;
    private LocalDate dateAjoute;
}
