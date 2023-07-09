package pl.ttsw.mapstruct.mapstruct.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import pl.ttsw.mapstruct.mapstruct.util.ShipCrewId;

import java.sql.Date;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "SHIP_CREW")
public class ShipCrewEntity {

    @EmbeddedId
    private ShipCrewId shipCrewId;

    private Date creationDate;

    private Boolean isOnboard;

}
