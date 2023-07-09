package pl.ttsw.mapstruct.mapstruct.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;
import pl.ttsw.mapstruct.mapstruct.model.Nation;

import java.util.UUID;

@Data
public class SailorDTO {

    private UUID id;

    private String firstName;

    private String lastName;

    private String birthDay;

    @Enumerated(EnumType.STRING)
    private Nation nation;

}
