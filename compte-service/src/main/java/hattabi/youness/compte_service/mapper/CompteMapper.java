package hattabi.youness.compte_service.mapper;

import hattabi.youness.compte_service.dto.CompteRequestDTO;
import hattabi.youness.compte_service.dto.CompteResponseDTO;
import hattabi.youness.compte_service.entities.Compte;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface CompteMapper {
    CompteResponseDTO toDTO(Compte compte);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "dateCreation", ignore = true)
    Compte toEntity(CompteRequestDTO dto);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "dateCreation", ignore = true)
    void updateEntityFromDTO(CompteRequestDTO dto, @MappingTarget Compte compte);
}
