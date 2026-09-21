package hattabi.youness.compte_service.projections;

import hattabi.youness.compte_service.entities.Compte;
import hattabi.youness.compte_service.enums.TypeCompte;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "full", types = Compte.class)
public interface CompteProjection {
    Long getId();

    double getSolde();

    TypeCompte getType();
}
