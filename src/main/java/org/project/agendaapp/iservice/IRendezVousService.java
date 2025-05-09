package org.project.agendaapp.iservice;

import org.project.agendaapp.DTO.RendezVousDto;

import java.util.List;

public interface IRendezVousService {
    RendezVousDto createRendezVous(RendezVousDto rendezVousDto);
    RendezVousDto getRendezVousById(Long id);
    List<RendezVousDto> getAllRendezVous();
    void updateRendezVous(Long id, RendezVousDto rendezVousDto);
    void deleteRendezVous(Long id);
}
