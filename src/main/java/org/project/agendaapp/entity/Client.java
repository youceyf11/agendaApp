package org.project.agendaapp.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Table(name= "clients")
@Getter
@Setter
public class Client extends User{

    @OneToOne
    private User user;

    @OneToOne(mappedBy = "client", cascade = CascadeType.ALL)
    private FicheClient fiche;


}
