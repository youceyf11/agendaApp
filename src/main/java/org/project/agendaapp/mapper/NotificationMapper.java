package org.project.agendaapp.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.project.agendaapp.DTO.NotificationDto;
import org.project.agendaapp.entity.Notification;

@Mapper(componentModel = "spring"
        ,nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface NotificationMapper {
    NotificationDto toDto(Notification notification);
    Notification toEntity(NotificationDto notificationDto);

    @Mapping(target = "id", ignore = true)
    void updateNotificationFromDto(NotificationDto notificationDto, Notification notification);
}
