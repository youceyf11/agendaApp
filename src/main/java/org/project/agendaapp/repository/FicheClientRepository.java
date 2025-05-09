package org.project.agendaapp.repository;

import org.project.agendaapp.entity.FicheClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FicheClientRepository extends JpaRepository<FicheClient,Long> {
}
