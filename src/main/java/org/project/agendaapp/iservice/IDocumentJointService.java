package org.project.agendaapp.iservice;

import org.project.agendaapp.DTO.ClientDto;

import java.util.List;

public interface IDocumentJointService {
    ClientDto createClient(ClientDto clientDto);
    ClientDto getClientById(Long id);
    List<ClientDto> getAllClients();
    void updateClient(Long id, ClientDto clientDto);
    void deleteClient(Long id);
}
