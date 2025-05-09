package org.project.agendaapp.iservice;

import org.project.agendaapp.DTO.ProfessionalDto;

import java.util.List;

public interface IProfessionalService {
    ProfessionalDto createProfessional(ProfessionalDto professionalDto);
    ProfessionalDto getProfessionalById(Long id);
    List<ProfessionalDto> getAllProfessionals();
    void updateProfessional(Long id, ProfessionalDto professionalDto);
    void deleteProfessional(Long id);
}
