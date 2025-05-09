package org.project.agendaapp.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.project.agendaapp.DTO.FicheClientDto;
import org.project.agendaapp.entity.FicheClient;

@Mapper(componentModel = "spring"
        ,nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface FicheClientMapper {
     FicheClientDto toDto(FicheClient ficheClient);
     FicheClient toEntity(FicheClientDto ficheClientDto);

     @Mapping(target = "id", ignore = true)
     void updateFicheClientFromDto(FicheClientDto ficheClientDto, FicheClient ficheClient);
}
