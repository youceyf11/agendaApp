package org.project.agendaapp.iservice;



public interface INotificationService {
    void sendNotificationToClient(Long clientId, String message);
    void sendNotificationToProfessional(Long professionalId, String message);
}
