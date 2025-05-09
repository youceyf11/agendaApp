package org.project.agendaapp.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.project.agendaapp.DTO.RendezVousDto;
import org.project.agendaapp.entity.RendezVous;
import org.project.agendaapp.exception.TechnicalException;
import org.project.agendaapp.iservice.IRendezVousService;
import org.project.agendaapp.mapper.RendezVousMapper;
import org.project.agendaapp.repository.RendezVousRepository;
import org.project.agendaapp.Enum.ErrorCode;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RendezVousService implements IRendezVousService {

    private final RendezVousRepository rendezVousRepository;
    private final RendezVousMapper rendezVousMapper;

    @Override
    @Transactional
    public RendezVousDto createRendezVous(RendezVousDto rendezVousDto) {
        try {
            boolean isOccupied= rendezVousRepository.existsByProfessionalIdAndDateHeure(rendezVousDto.getDateHeureDebut(),rendezVousDto.getDateHeureFin(), rendezVousDto.getProfessionalId());
            if (isOccupied) {
                throw new TechnicalException("Le professionnel est déjà occupé à ce créneau, veuillez choisir une autre date et heure.");
            }
            RendezVous rendezVous = rendezVousMapper.toEntity(rendezVousDto);
            RendezVous saved = rendezVousRepository.save(rendezVous);
            return rendezVousMapper.toDto(saved);
        } catch (Exception e) {
            throw new TechnicalException(ErrorCode.DATABASE_ERROR);
        }
    }

    @Override
    public RendezVousDto getRendezVousById(Long id) {
        RendezVous rendezVous = rendezVousRepository.findById(id)
                .orElseThrow(() -> new TechnicalException(ErrorCode.RENDEZ_VOUS_NOT_FOUND));
        try {
            return rendezVousRepository.findById(id)
                    .map(rendezVousMapper::toDto)
                    .orElseThrow(() -> new TechnicalException(ErrorCode.RENDEZ_VOUS_NOT_FOUND));
        } catch (Exception e) {
            throw new TechnicalException(ErrorCode.DATABASE_ERROR);
        }
    }

    @Override
    public List<RendezVousDto> getAllRendezVous() {
        try {
            return rendezVousRepository.findAll().stream()
                    .map(rendezVousMapper::toDto)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new TechnicalException(ErrorCode.DATABASE_ERROR);
        }
    }

    @Override
    @Transactional
    public void updateRendezVous(Long id, RendezVousDto rendezVousDto) {
        RendezVous rendezVous = rendezVousRepository.findById(id)
                .orElseThrow(() -> new TechnicalException(ErrorCode.RENDEZ_VOUS_NOT_FOUND));
        try {
            rendezVousMapper.updateRendezVousFromDto(rendezVousDto, rendezVous);
            rendezVousRepository.save(rendezVous);
        } catch (Exception e) {
            throw new TechnicalException(ErrorCode.DATABASE_ERROR);
        }
    }

    @Override
    @Transactional
    public void deleteRendezVous(Long id) {
        if (!rendezVousRepository.existsById(id)) {
            throw new TechnicalException(ErrorCode.RENDEZ_VOUS_NOT_FOUND);
        }
        try {
            rendezVousRepository.deleteById(id);
        } catch (Exception e) {
            throw new TechnicalException(ErrorCode.DATABASE_ERROR);
        }
    }
}