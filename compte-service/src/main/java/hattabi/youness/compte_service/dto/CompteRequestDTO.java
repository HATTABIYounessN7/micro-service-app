package hattabi.youness.compte_service.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import hattabi.youness.compte_service.enums.TypeCompte;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CompteRequestDTO {
    @Min(value = 0, message = "Le solde doit être positif")
    private double solde;

    @NotNull(message = "Le type de compte est obligatoire")
    private TypeCompte type;
}
