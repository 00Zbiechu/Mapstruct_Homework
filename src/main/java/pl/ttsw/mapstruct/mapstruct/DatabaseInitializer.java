package pl.ttsw.mapstruct.mapstruct;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.ttsw.mapstruct.mapstruct.entity.SailorEntity;
import pl.ttsw.mapstruct.mapstruct.entity.ShipCrewEntity;
import pl.ttsw.mapstruct.mapstruct.entity.ShipEntity;
import pl.ttsw.mapstruct.mapstruct.model.Country;
import pl.ttsw.mapstruct.mapstruct.model.Nation;
import pl.ttsw.mapstruct.mapstruct.model.ShipStatus;
import pl.ttsw.mapstruct.mapstruct.repository.SailorRepository;
import pl.ttsw.mapstruct.mapstruct.repository.ShipCrewRepository;
import pl.ttsw.mapstruct.mapstruct.repository.ShipRepository;
import pl.ttsw.mapstruct.mapstruct.util.ShipCrewId;

import java.sql.Date;
import java.time.LocalDate;

@Component
@RequiredArgsConstructor
public class DatabaseInitializer {

    private final ShipRepository shipRepository;

    private final SailorRepository sailorRepository;

    private final ShipCrewRepository shipCrewRepository;

    @PostConstruct
    public void initDb() {

        ShipEntity shipEntity = ShipEntity.builder()
                .name("Test")
                .country(Country.PORTUGAL)
                .capacity("12")
                .buildDate(LocalDate.now().minusYears(10))
                .status(ShipStatus.MOORED)
                .build();

        shipRepository.save(shipEntity);

        SailorEntity sailorEntity = SailorEntity.builder()
                .firstName("Testowy")
                .lastName("Testowski")
                .birthDate(LocalDate.of(1998, 4, 3))
                .nation(Nation.POLISH)
                .build();

        sailorRepository.save(sailorEntity);


        ShipCrewEntity shipCrewEntity = ShipCrewEntity.builder()
                .shipCrewId(ShipCrewId.builder()
                        .ship(shipEntity)
                        .sailor(sailorEntity)
                        .build())
                .creationDate(Date.valueOf("2023-02-14"))
                .isOnboard(true)
                .build();

        shipCrewRepository.save(shipCrewEntity);


    }

}
