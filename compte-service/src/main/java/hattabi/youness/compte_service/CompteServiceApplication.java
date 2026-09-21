package hattabi.youness.compte_service;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hattabi.youness.compte_service.entities.Compte;
import hattabi.youness.compte_service.enums.TypeCompte;
import hattabi.youness.compte_service.repositories.CompteRepository;

import java.util.List;

@SpringBootApplication
public class CompteServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CompteServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(CompteRepository compteRepository) {
		return args -> {
			List.of(
					Compte.builder()
							.solde(10000.0)
							.dateCreation(LocalDate.now())
							.type(TypeCompte.COURANT)
							.build(),
					Compte.builder()
							.solde(25000.0)
							.dateCreation(LocalDate.now())
							.type(TypeCompte.EPARGNE)
							.build(),
					Compte.builder()
							.solde(5500.0)
							.dateCreation(LocalDate.now())
							.type(TypeCompte.COURANT)
							.build())
					.forEach(compteRepository::save);

			System.out.println("All Comptes");
			compteRepository.findAll().forEach(System.out::println);

			System.out.println("Comptes COURANT");
			compteRepository.findByType(TypeCompte.COURANT).forEach(System.out::println);
		};
	}
}
