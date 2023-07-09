package pl.ttsw.mapstruct.mapstruct.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import pl.ttsw.mapstruct.mapstruct.dto.SailorDTO;
import pl.ttsw.mapstruct.mapstruct.entity.SailorEntity;

@Mapper(componentModel = "spring")
public interface SailorMapper {

    SailorMapper INSTANCE = Mappers.getMapper(SailorMapper.class);

    @Mapping(source = "birthDate", target = "birthDay", dateFormat = "yyyy.MM.dd")
    SailorDTO toDTO(SailorEntity sailorEntity);

    @Mapping(source = "birthDay", target = "birthDate", dateFormat = "yyyy.MM.dd")
    SailorEntity toEntity(SailorDTO sailorDTO);

}
