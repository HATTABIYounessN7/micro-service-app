package hattabi.youness.compte_service.repositories;

import hattabi.youness.compte_service.entities.Compte;
import hattabi.youness.compte_service.enums.TypeCompte;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CompteRepository extends JpaRepository<Compte, Long> {
    List<Compte> findByType(TypeCompte type);
}
