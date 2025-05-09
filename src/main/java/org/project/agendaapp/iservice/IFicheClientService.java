package org.project.agendaapp.iservice;

import org.project.agendaapp.DTO.FicheClientDto;

import java.util.List;


public interface IFicheClientService {
        FicheClientDto createFicheClient(FicheClientDto ficheClientDto);
        FicheClientDto getFicheClientById(Long id);
        List<FicheClientDto> getAllFicheClients();
        void updateFicheClient(Long id, FicheClientDto ficheClientDto);
        void deleteFicheClient(Long id);
    }


