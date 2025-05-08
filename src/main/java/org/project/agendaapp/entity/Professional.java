package org.project.agendaapp.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Table(name= "professionals")
@Getter
@SuperBuilder
@Setter
public class Professional extends User{

    @OneToOne
    private User user;

    private String specialite;
    private String adresse;
    private String ville;



}
