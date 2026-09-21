package hattabi.youness.compte_service.web;

import hattabi.youness.compte_service.dto.CompteRequestDTO;
import hattabi.youness.compte_service.dto.CompteResponseDTO;
import hattabi.youness.compte_service.service.CompteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comptes")
public class CompteRestController {
    private final CompteService compteService;

    public CompteRestController(CompteService compteService) {
        this.compteService = compteService;
    }

    @GetMapping
    public List<CompteResponseDTO> getAllComptes() {
        return compteService.getAllComptes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompteResponseDTO> getCompteById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(compteService.getCompteById(id));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CompteResponseDTO createCompte(@RequestBody CompteRequestDTO dto) {
        return compteService.saveCompte(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CompteResponseDTO> updateCompte(
            @PathVariable Long id,
            @RequestBody CompteRequestDTO dto) {
        try {
            return ResponseEntity.ok(compteService.updateCompte(id, dto));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCompte(@PathVariable Long id) {
        try {
            compteService.deleteCompte(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
