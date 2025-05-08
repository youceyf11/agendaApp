package org.project.agendaapp.entity;

import jakarta.persistence.*;
import lombok.*;
import org.project.agendaapp.Enum.Priorite;
import org.project.agendaapp.Enum.StatutTache;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name= "taches")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Tache {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titre;
    private String description;
    private LocalDate dateEcheance;

    @Enumerated(EnumType.STRING)
    private Priorite priorite;

    @Enumerated(EnumType.STRING)
    private StatutTache statut;

    @ManyToOne
    private Professional professionnel;

    @ManyToOne
    private RendezVous rendezVous;

    private LocalDateTime dateCreation;
}
