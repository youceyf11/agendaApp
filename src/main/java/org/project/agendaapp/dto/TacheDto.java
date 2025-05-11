package org.project.agendaapp.DTO;


import lombok.*;
import org.project.agendaapp.Enum.Priorite;
import org.project.agendaapp.Enum.StatutTache;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TacheDto {
    private Long id;
    private String titre;
    private String description;
    private LocalDateTime dateCreation;
    private Priorite priorite;
    private StatutTache statut;
}
