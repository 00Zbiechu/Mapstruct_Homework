package pl.ttsw.mapstruct.mapstruct.mapper;

import lombok.RequiredArgsConstructor;
import pl.ttsw.mapstruct.mapstruct.dto.SailorDTO;
import pl.ttsw.mapstruct.mapstruct.dto.ShipDTO;
import pl.ttsw.mapstruct.mapstruct.entity.ShipCrewEntity;
import pl.ttsw.mapstruct.mapstruct.entity.ShipEntity;
import pl.ttsw.mapstruct.mapstruct.model.ShipStatus;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public abstract class ShipMapperDecorator implements ShipMapper {

    private final ShipMapper shipMapper;

    @Override
    public ShipDTO toDTO(ShipEntity shipEntity) {

        ShipDTO shipDTO = shipMapper.toDTO(shipEntity);

        convertLocalDateToStringWithPattern("dd.MM.yyyy", shipEntity, shipDTO);

        setBooleanStatusIfShipIsAvailable(shipEntity, shipDTO);

        setActualOnboardCrewCount(shipEntity, shipDTO);

        setShipCrewAsSetSailorDTO(shipEntity, shipDTO);

        return shipDTO;

    }


    private void convertLocalDateToStringWithPattern(String pattern, ShipEntity shipEntity, ShipDTO shipDto) {

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(pattern);
        shipDto.setBuildDate(shipEntity.getBuildDate().format(dateTimeFormatter));

    }


    private void setBooleanStatusIfShipIsAvailable(ShipEntity shipEntity, ShipDTO shipDTO) {
        shipDTO.setAvailable(shipEntity.getStatus() == ShipStatus.MOORED);
    }

    private void setActualOnboardCrewCount(ShipEntity ship, ShipDTO shipDTO) {

        List<ShipCrewEntity> actualOnboardCrewCount = ship.getShipCrew().stream().filter(ShipCrewEntity::getIsOnboard).toList();
        shipDTO.setActualOnboardCrewCount(actualOnboardCrewCount.size());

    }

    private void setShipCrewAsSetSailorDTO(ShipEntity ship, ShipDTO shipDTO) {

        Set<SailorDTO> sailorDTOList = ship.getShipCrew().stream()
                .map(shipCrewEntity -> shipCrewEntity.getShipCrewId().getSailor())
                .map(SailorMapper.INSTANCE::toDTO)
                .collect(Collectors.toSet());

        shipDTO.setShipCrew(sailorDTOList);

    }


    @Override
    public ShipEntity toEntity(ShipDTO shipDTO) {

        ShipEntity shipEntity = shipMapper.toEntity(shipDTO);

        setShipStatusFromShipBooleanStatus(shipDTO, shipEntity);

        return shipEntity;

    }


    private static void setShipStatusFromShipBooleanStatus(ShipDTO shipDTO, ShipEntity shipEntity) {
        if (shipDTO.isAvailable()) {
            shipEntity.setStatus(ShipStatus.MOORED);
        } else {
            shipEntity.setStatus(ShipStatus.ON_TRAIL);
        }
    }
}
