package hattabi.youness.compte_service.entities;

import jakarta.persistence.*;
import lombok.*;
import hattabi.youness.compte_service.enums.TypeCompte;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class Compte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double solde;

    private LocalDate dateCreation;

    @Enumerated(EnumType.STRING)
    private TypeCompte type;
}
