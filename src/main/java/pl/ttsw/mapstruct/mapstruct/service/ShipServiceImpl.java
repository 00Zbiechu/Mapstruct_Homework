package pl.ttsw.mapstruct.mapstruct.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.ttsw.mapstruct.mapstruct.dto.ShipDTO;
import pl.ttsw.mapstruct.mapstruct.entity.SailorEntity;
import pl.ttsw.mapstruct.mapstruct.entity.ShipCrewEntity;
import pl.ttsw.mapstruct.mapstruct.entity.ShipEntity;
import pl.ttsw.mapstruct.mapstruct.mapper.SailorMapper;
import pl.ttsw.mapstruct.mapstruct.mapper.ShipMapper;
import pl.ttsw.mapstruct.mapstruct.model.Ships;
import pl.ttsw.mapstruct.mapstruct.repository.SailorRepository;
import pl.ttsw.mapstruct.mapstruct.repository.ShipCrewRepository;
import pl.ttsw.mapstruct.mapstruct.repository.ShipRepository;
import pl.ttsw.mapstruct.mapstruct.util.ShipCrewId;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ShipServiceImpl implements ShipService {

    private final ShipRepository shipRepository;
    private final ShipCrewRepository shipCrewRepository;
    private final SailorMapper sailorMapper;
    private final SailorRepository sailorRepository;

    @Override
    public Ships get() {

        List<ShipDTO> ships = shipRepository.findAll().stream()
                .map(ShipMapper.INSTANCE::toDTO)
                .toList();

        return Ships.builder().ships(ships).build();

    }

    @Override
    public void save(ShipDTO shipDTO) {

        ShipEntity shipEntity = ShipMapper.INSTANCE.toEntity(shipDTO);

        Set<SailorEntity> sailorSet = shipDTO.getShipCrew().stream()
                .map(sailorMapper::toEntity)
                .collect(Collectors.toSet());

        shipRepository.save(shipEntity);

        for (SailorEntity sailor : sailorSet) {

            sailorRepository.save(sailor);

            ShipCrewEntity shipCrewEntity = ShipCrewEntity.builder()
                    .shipCrewId(ShipCrewId.builder()
                            .ship(shipEntity)
                            .sailor(sailor)
                            .build()).isOnboard(true)
                    .creationDate(Date.valueOf(LocalDate.now()))
                    .build();

            shipCrewRepository.save(shipCrewEntity);

        }


    }

}
