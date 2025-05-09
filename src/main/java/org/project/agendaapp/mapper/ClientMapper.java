package org.project.agendaapp.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.project.agendaapp.DTO.ClientDto;
import org.project.agendaapp.entity.Client;

@Mapper(componentModel = "spring"
        ,nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ClientMapper {
    ClientDto toDto(Client client);
    Client toEntity(ClientDto clientDto);

    @Mapping(target = "id", ignore = true)
    void updateCLientFromDto(ClientDto clientDto, Client client);
}
