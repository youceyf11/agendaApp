package org.project.agendaapp.iservice;

import org.project.agendaapp.DTO.TacheDto;

import java.util.List;

public interface ITacheService {
    TacheDto createTache(TacheDto tacheDto);
    TacheDto getTacheById(Long id);
    List<TacheDto> getAllTaches();
    void updateTache(Long id, TacheDto tacheDto);
    void deleteTache(Long id);
}
