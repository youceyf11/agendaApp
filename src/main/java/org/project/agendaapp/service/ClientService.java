package org.project.agendaapp.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.project.agendaapp.DTO.ClientDto;
import org.project.agendaapp.entity.Client;
import org.project.agendaapp.exception.TechnicalException;
import org.project.agendaapp.iservice.IClientService;
import org.project.agendaapp.mapper.ClientMapper;
import org.project.agendaapp.repository.ClientRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import org.project.agendaapp.Enum.ErrorCode;
import java.util.List;
import java.util.stream.Collectors;



@Service
@RequiredArgsConstructor
public class ClientService implements IClientService {

    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;
    private final PasswordEncoder passwordEncoder;


    @Override
    @Transactional
    public String createClient(ClientDto clientDto) {
        try {
            Client client = clientMapper.toEntity(clientDto);
            client.setPassword(passwordEncoder.encode(client.getPassword()));
            Client savedClient = clientRepository.save(client);
            return savedClient.getId().toString();
        } catch (Exception e) {
            throw new TechnicalException(ErrorCode.DATABASE_ERROR);
        }
    }

    @Override
    public ClientDto getClientById(Long id) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new TechnicalException(ErrorCode.CLIENT_NOT_FOUND));
        try {
            return clientRepository.findById(id)
                    .map(clientMapper::toDto)
                    .orElseThrow(() -> new TechnicalException(ErrorCode.CLIENT_NOT_FOUND));
        }catch (Exception e){
            throw new TechnicalException(ErrorCode.DATABASE_ERROR);
        }
    }

    @Override
    public List<ClientDto> getAllClients() {
        try {
            return clientRepository.findAll().stream()
                    .map(clientMapper::toDto)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new TechnicalException(ErrorCode.DATABASE_ERROR);
        }
    }

    @Override
    @Transactional
    public void updateClient(Long id, ClientDto clientDto) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new TechnicalException(ErrorCode.CLIENT_NOT_FOUND));
        try {
            clientMapper.updateCLientFromDto(clientDto, client);
            clientRepository.save(client);
        } catch (Exception e) {
            throw new TechnicalException(ErrorCode.DATABASE_ERROR);
        }
    }

    @Override
    @Transactional
    public void deleteClient(Long id) {
        if(!clientRepository.existsById(id)) {
            throw new TechnicalException(ErrorCode.CLIENT_NOT_FOUND);
        }
        try {
            clientRepository.deleteById(id);
        } catch (Exception e) {
            throw new TechnicalException(ErrorCode.DATABASE_ERROR);
        }
    }
}
