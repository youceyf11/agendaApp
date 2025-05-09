package org.project.agendaapp.repository;

import org.project.agendaapp.entity.RendezVous;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface RendezVousRepository extends JpaRepository<RendezVous, Long> {
    boolean existsByProfessionalIdAndDateHeure(LocalDateTime dateHeureDebut,LocalDateTime dateHeureFin, Long professionalId);
}
