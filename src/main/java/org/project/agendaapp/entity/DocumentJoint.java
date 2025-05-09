package org.project.agendaapp.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Table(name= "documents_joints")
@Getter
@Setter
public class DocumentJoint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomFichier;
    private String url;
    private String typeFichier;

    @ManyToOne
    private FicheClient fiche;

    private LocalDate dateAjoute;
}
