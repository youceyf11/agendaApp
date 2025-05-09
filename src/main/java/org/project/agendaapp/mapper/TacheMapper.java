package org.project.agendaapp.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.project.agendaapp.DTO.TacheDto;
import org.project.agendaapp.entity.Tache;

@Mapper(componentModel = "spring"
        ,nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface TacheMapper {
     TacheDto toDto(Tache tache);
     Tache toEntity(TacheDto tacheDto);

     @Mapping(target = "id", ignore = true)
     void updateTacheFromDto(TacheDto tacheDto, Tache tache);
}
