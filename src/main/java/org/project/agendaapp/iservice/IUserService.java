package org.project.agendaapp.iservice;

import org.project.agendaapp.DTO.PasswordDto;
import org.project.agendaapp.DTO.UsernameDto;

public interface IUserService {

    void updatePassword(String id, PasswordDto passwordDTO);
    void updateUserName(String id, UsernameDto usernameDTO);
}
