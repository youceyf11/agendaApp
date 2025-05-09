package org.project.agendaapp.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.project.agendaapp.DTO.DocumentJointDto;
import org.project.agendaapp.entity.DocumentJoint;

@Mapper(componentModel = "spring"
        ,nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface DocumentJointMapper {
     DocumentJointDto toDto(DocumentJoint documentJoint);
     DocumentJoint toEntity(DocumentJointDto documentJointDto);

     @Mapping(target = "id", ignore = true)
     void updateDocumentJointFromDto(DocumentJointDto documentJointDto, DocumentJoint documentJoint);
}
