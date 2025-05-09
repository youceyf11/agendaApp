package org.project.agendaapp.entity;

import jakarta.persistence.*;
import lombok.*;
import org.project.agendaapp.Enum.StatutRendezVous;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Table(name= "rendezvous")
@Getter
@Setter
@Builder
public class RendezVous {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dateHeureDebut;
    private LocalDateTime dateHeureFin;

    @Enumerated(EnumType.STRING)
    private StatutRendezVous statutRendezVous;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "professional_id")
    private Professional professional;
}
