package org.project.agendaapp.DTO;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class FicheClientDto {
    private long id;
    private String antecedent;
    private String remarque;

}
