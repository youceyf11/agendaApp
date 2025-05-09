package org.project.agendaapp.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.project.agendaapp.DTO.RendezVousDto;
import org.project.agendaapp.entity.RendezVous;

@Mapper(componentModel = "spring"
        ,nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface RendezVousMapper {
     RendezVousDto toDto(RendezVous rendezVous);
     RendezVous toEntity(RendezVousDto rendezVousDto);

     @Mapping(target = "id", ignore = true)
     void updateRendezVousFromDto(RendezVousDto rendezVousDto, RendezVous rendezVous);
}
