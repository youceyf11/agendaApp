package org.project.agendaapp.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.project.agendaapp.DTO.DisponibilteDto;
import org.project.agendaapp.entity.Disponibilte;

@Mapper(componentModel = "spring"
        ,nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface DisponibilteMapper {
    DisponibilteDto toDto(Disponibilte disponibilte);
    Disponibilte toEntity(DisponibilteDto disponibilteDto);

    @Mapping(target = "id", ignore = true)
    void updateDisponibilteFromDto(DisponibilteDto disponibilteDto, Disponibilte disponibilte);
}

