package org.project.agendaapp.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.project.agendaapp.DTO.ProfessionalDto;
import org.project.agendaapp.entity.Professional;

@Mapper(componentModel = "spring"
        ,nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ProfessionalMapper {

     ProfessionalDto toDto(Professional professional);
    Professional toEntity(ProfessionalDto professionalDto);

    @Mapping(target = "id", ignore = true)
    void updateProfessionalFromDto(ProfessionalDto professionalDto, Professional professional);
}
