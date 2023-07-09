package pl.ttsw.mapstruct.mapstruct.mapper;

import org.mapstruct.*;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;
import pl.ttsw.mapstruct.mapstruct.dto.ShipDTO;
import pl.ttsw.mapstruct.mapstruct.entity.ShipEntity;

import java.time.LocalDate;

@Component
@Mapper(uses = SailorMapper.class)
@DecoratedWith(ShipMapperDecorator.class)
public interface ShipMapper {

    ShipMapper INSTANCE = Mappers.getMapper(ShipMapper.class);

    @Mapping(source = "name", target = "ship")
    @ValueMappings({
            @ValueMapping(source = "POLAND", target = "POLISH"),
            @ValueMapping(source = "FRANCE", target = "FRENCH"),
            @ValueMapping(source = "PORTUGAL", target = "PORTUGUESE")
    })
    @Mapping(source = "buildDate", target = "age", qualifiedByName = "countAge")
    ShipDTO toDTO(ShipEntity shipEntity);

    @Named("countAge")
    default Integer countAge(LocalDate buildDate) {

        return LocalDate.now().getYear() - buildDate.getYear();

    }


    @Mapping(source = "ship", target = "name")
    @ValueMappings({
            @ValueMapping(source = "POLISH", target = "POLAND"),
            @ValueMapping(source = "FRENCH", target = "FRANCE"),
            @ValueMapping(source = "PORTUGUESE", target = "PORTUGAL")
    })
    @Mapping(source = "shipCrew", target = "shipCrew", ignore = true)
    @Mapping(source = "buildDate", target = "buildDate", dateFormat = "yyyy.MM.dd")
    ShipEntity toEntity(ShipDTO shipDTO);

}
