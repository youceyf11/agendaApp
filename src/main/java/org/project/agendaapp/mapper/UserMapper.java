package org.project.agendaapp.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.project.agendaapp.DTO.UserDto;
import org.project.agendaapp.entity.User;

@Mapper(componentModel = "spring"
        ,nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface UserMapper {
     UserDto toDto(User user);
     User toEntity(UserDto userDto);

     @Mapping(target = "id", ignore = true)
     void updateUserFromDto(UserDto userDto, User user);
}
