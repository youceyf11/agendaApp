package org.project.agendaapp.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.project.agendaapp.DTO.ProfessionalDto;
import org.project.agendaapp.entity.Professional;
import org.project.agendaapp.exception.TechnicalException;
import org.project.agendaapp.iservice.IProfessionalService;
import org.project.agendaapp.mapper.ProfessionalMapper;
import org.project.agendaapp.repository.ProfessionalRepository;
import org.project.agendaapp.Enum.ErrorCode;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProfessionalService implements IProfessionalService {

    private final ProfessionalRepository professionalRepository;
    private final ProfessionalMapper professionalMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public ProfessionalDto createProfessional(ProfessionalDto professionalDto) {
        try {
            Professional professional = professionalMapper.toEntity(professionalDto);
            professional.setPassword(passwordEncoder.encode(professional.getPassword()));
            Professional savedProfessional = professionalRepository.save(professional);
            return professionalMapper.toDto(savedProfessional);
        } catch (Exception e) {
            throw new TechnicalException(ErrorCode.DATABASE_ERROR);
        }
    }

    @Override
    public ProfessionalDto getProfessionalById(Long id) {
        Professional professional = professionalRepository.findById(id)
                .orElseThrow(() -> new TechnicalException(ErrorCode.PROFESSIONAL_NOT_FOUND));
        try {
            return professionalRepository.findById(id)
                    .map(professionalMapper::toDto)
                    .orElseThrow(() -> new TechnicalException(ErrorCode.CLIENT_NOT_FOUND));
        } catch (Exception e) {
            throw new TechnicalException(ErrorCode.DATABASE_ERROR);
        }
    }

    @Override
    public List<ProfessionalDto> getAllProfessionals() {
        try {
            return professionalRepository.findAll().stream()
                    .map(professionalMapper::toDto)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new TechnicalException(ErrorCode.DATABASE_ERROR);
        }
    }

    @Override
    @Transactional
    public void updateProfessional(Long id, ProfessionalDto professionalDto) {
        Professional professional = professionalRepository.findById(id)
                .orElseThrow(() -> new TechnicalException(ErrorCode.CLIENT_NOT_FOUND));
        try {
            professionalMapper.updateProfessionalFromDto(professionalDto, professional);
            professionalRepository.save(professional);
        } catch (Exception e) {
            throw new TechnicalException(ErrorCode.DATABASE_ERROR);
        }
    }

    @Override
    @Transactional
    public void deleteProfessional(Long id) {
        if (!professionalRepository.existsById(id)) {
            throw new TechnicalException(ErrorCode.CLIENT_NOT_FOUND);
        }
        try {
            professionalRepository.deleteById(id);
        } catch (Exception e) {
            throw new TechnicalException(ErrorCode.DATABASE_ERROR);
        }
    }
}