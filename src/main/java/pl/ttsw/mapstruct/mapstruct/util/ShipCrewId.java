package pl.ttsw.mapstruct.mapstruct.util;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.ttsw.mapstruct.mapstruct.entity.SailorEntity;
import pl.ttsw.mapstruct.mapstruct.entity.ShipEntity;

import java.io.Serializable;

@Embeddable
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ShipCrewId implements Serializable {

    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private ShipEntity ship;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private SailorEntity sailor;


}
