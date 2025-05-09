package org.project.agendaapp.repository;

import org.project.agendaapp.entity.DocumentJoint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentJointRepository extends JpaRepository<DocumentJoint,Long> {
}
