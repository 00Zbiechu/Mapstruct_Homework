package pl.ttsw.mapstruct.mapstruct.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.ttsw.mapstruct.mapstruct.entity.ShipCrewEntity;
import pl.ttsw.mapstruct.mapstruct.util.ShipCrewId;

@Repository
public interface ShipCrewRepository extends JpaRepository<ShipCrewEntity, ShipCrewId> {
}
