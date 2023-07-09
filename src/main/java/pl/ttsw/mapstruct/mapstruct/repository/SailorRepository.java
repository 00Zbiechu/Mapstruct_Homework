package pl.ttsw.mapstruct.mapstruct.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.ttsw.mapstruct.mapstruct.entity.SailorEntity;

import java.util.UUID;

@Repository
public interface SailorRepository extends JpaRepository<SailorEntity, UUID> {
}
