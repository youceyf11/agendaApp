package org.project.agendaapp.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.DayOfWeek;
import java.time.LocalTime;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Disponibilte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private DayOfWeek jourSemaine;
    private LocalTime heureDebut;
    private LocalTime heureFin;

    @ManyToOne
    private Professional professionnel;


}
