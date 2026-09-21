package hattabi.youness.compte_service.service;

import lombok.RequiredArgsConstructor;
import hattabi.youness.compte_service.dto.CompteRequestDTO;
import hattabi.youness.compte_service.dto.CompteResponseDTO;
import hattabi.youness.compte_service.entities.Compte;
import hattabi.youness.compte_service.mapper.CompteMapper;
import hattabi.youness.compte_service.repositories.CompteRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CompteServiceImpl implements CompteService {
    private final CompteRepository compteRepository;
    private final CompteMapper compteMapper;

    @Override
    @Transactional(readOnly = true)
    public List<CompteResponseDTO> getAllComptes() {
        return compteRepository.findAll()
                .stream()
                .map(compteMapper::toDTO)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public CompteResponseDTO getCompteById(Long id) {
        Compte compte = compteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Compte introuvable avec l'id: " + id));
        return compteMapper.toDTO(compte);
    }

    @Override
    public CompteResponseDTO saveCompte(CompteRequestDTO dto) {
        Compte compte = compteMapper.toEntity(dto);
        compte.setDateCreation(LocalDate.now());
        Compte saved = compteRepository.save(compte);
        return compteMapper.toDTO(saved);
    }

    @Override
    public CompteResponseDTO updateCompte(Long id, CompteRequestDTO dto) {
        Compte compte = compteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Compte introuvable avec l'id: " + id));
        compteMapper.updateEntityFromDTO(dto, compte);
        return compteMapper.toDTO(compteRepository.save(compte));
    }

    @Override
    public void deleteCompte(Long id) {
        if (!compteRepository.existsById(id)) {
            throw new RuntimeException("Compte introuvable avec l'id: " + id);
        }
        compteRepository.deleteById(id);
    }
}
