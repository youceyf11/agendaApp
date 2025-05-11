package org.project.agendaapp.DTO;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NotificationDto {
    private Long id;
    private String message;
    private LocalDateTime dateEnvoi;
    private boolean lu;
    private Long destinataireId;
}
