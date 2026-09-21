package hattabi.youness.compte_service.projections;

import hattabi.youness.compte_service.entities.Compte;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "solde", types = Compte.class)
public interface CompteSoldeProjection {
    Long getId();

    double getSolde();
}
