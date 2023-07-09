package pl.ttsw.mapstruct.mapstruct.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.ttsw.mapstruct.mapstruct.model.Country;
import pl.ttsw.mapstruct.mapstruct.model.ShipStatus;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Data
@Builder
@Table(name = "SHIP")
@NoArgsConstructor
@AllArgsConstructor
public class ShipEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private BigInteger id;

    private String name;

    private String capacity;

    @Enumerated(EnumType.STRING)
    private Country country;

    private LocalDate buildDate;

    @Enumerated(EnumType.STRING)
    private ShipStatus status;

    @OneToMany(mappedBy = "shipCrewId.ship")
    private Set<ShipCrewEntity> shipCrew;

}
