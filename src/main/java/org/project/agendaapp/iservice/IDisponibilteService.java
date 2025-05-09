package org.project.agendaapp.iservice;


import java.time.LocalDateTime;

public interface IDisponibilteService {
    boolean isDisponible( LocalDateTime dateHeureDebut, LocalDateTime dateHeureFin,Long professionalId);

}
