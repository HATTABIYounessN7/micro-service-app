package hattabi.youness.compte_service.web;

import lombok.RequiredArgsConstructor;
import hattabi.youness.compte_service.dto.CompteRequestDTO;
import hattabi.youness.compte_service.dto.CompteResponseDTO;
import hattabi.youness.compte_service.enums.TypeCompte;
import hattabi.youness.compte_service.service.CompteService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class CompteGraphQLController {
    private final CompteService compteService;

    @QueryMapping
    public List<CompteResponseDTO> allComptes() {
        return compteService.getAllComptes();
    }

    @QueryMapping
    public CompteResponseDTO compteById(@Argument Long id) {
        return compteService.getCompteById(id);
    }

    @QueryMapping
    public List<CompteResponseDTO> comptesByType(@Argument TypeCompte type) {
        return compteService.getAllComptes()
                .stream()
                .filter(c -> c.getType() == type)
                .toList();
    }

    @MutationMapping
    public CompteResponseDTO saveCompte(@Argument CompteRequestDTO compte) {
        return compteService.saveCompte(compte);
    }

    @MutationMapping
    public boolean deleteCompte(@Argument Long id) {
        compteService.deleteCompte(id);
        return true;
    }
}
