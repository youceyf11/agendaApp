package org.project.agendaapp.service;

import lombok.RequiredArgsConstructor;

import org.project.agendaapp.exception.TechnicalException;
import org.project.agendaapp.iservice.IDisponibilteService;

import org.project.agendaapp.Enum.ErrorCode;
import org.project.agendaapp.repository.RendezVousRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
@RequiredArgsConstructor
public class DisponibilteService implements IDisponibilteService {

    private final RendezVousRepository rendezVousRepository;

    @Override
    public boolean isDisponible( LocalDateTime dateHeureDebut, LocalDateTime dateHeureFin,Long professionalId) {
        try {
            boolean isOccupied = rendezVousRepository
                    .existsByProfessionalIdAndDateHeure(
                              dateHeureDebut,dateHeureFin,professionalId
                    );
            return !isOccupied;
        } catch (Exception e) {
            throw new TechnicalException(ErrorCode.DATABASE_ERROR);
        }
    }
    }
