package hattabi.youness.compte_service.service;

import java.util.List;

import hattabi.youness.compte_service.dto.CompteRequestDTO;
import hattabi.youness.compte_service.dto.CompteResponseDTO;

public interface CompteService {
    List<CompteResponseDTO> getAllComptes();

    CompteResponseDTO getCompteById(Long id);

    CompteResponseDTO saveCompte(CompteRequestDTO dto);

    CompteResponseDTO updateCompte(Long id, CompteRequestDTO dto);

    void deleteCompte(Long id);
}
