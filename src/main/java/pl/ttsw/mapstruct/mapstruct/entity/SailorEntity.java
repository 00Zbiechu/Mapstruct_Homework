package pl.ttsw.mapstruct.mapstruct.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.ttsw.mapstruct.mapstruct.model.Nation;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

@Entity
@Data
@Builder
@NoArgsConstructor
@Table(name = "SAILOR")
@AllArgsConstructor
public class SailorEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String firstName;

    private String lastName;

    private LocalDate birthDate;

    @Enumerated(EnumType.STRING)
    private Nation nation;

    @OneToMany(mappedBy = "shipCrewId.sailor")
    private Set<ShipCrewEntity> shipCrew;


}
