package pl.ttsw.mapstruct.mapstruct.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;
import pl.ttsw.mapstruct.mapstruct.model.Nation;

import java.util.Set;

@Data
public class ShipDTO {

    private String id;

    private String ship;

    private Integer capacity;

    @Enumerated(EnumType.STRING)
    private Nation country;

    private Set<SailorDTO> shipCrew;

    private Integer age;

    private String buildDate;

    private boolean available;

    private Integer actualOnboardCrewCount;

}
