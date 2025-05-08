package org.project.agendaapp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Table(name= "fiche_clients")
@Getter
@Setter
public class FicheClient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @Lob
    private String notesPrivees;

    @OneToMany(mappedBy = "fiche", cascade = CascadeType.ALL)
    private List<DocumentJoint> documents;
}
