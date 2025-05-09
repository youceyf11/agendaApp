package org.project.agendaapp.DTO;

import lombok.*;

import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RendezVousDto {
    private Long id;
    private LocalDateTime dateHeureDebut;
    private LocalDateTime dateHeureFin;
    private String motif;
    private Long clientId;
    private Long professionalId;
}
