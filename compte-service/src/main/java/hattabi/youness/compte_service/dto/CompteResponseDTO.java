package hattabi.youness.compte_service.dto;

import java.time.LocalDate;

import hattabi.youness.compte_service.enums.TypeCompte;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CompteResponseDTO {
    private Long id;
    private double solde;
    private LocalDate dateCreation;
    private TypeCompte type;
}
