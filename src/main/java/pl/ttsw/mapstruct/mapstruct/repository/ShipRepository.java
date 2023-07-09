package pl.ttsw.mapstruct.mapstruct.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.ttsw.mapstruct.mapstruct.entity.ShipEntity;

import java.math.BigInteger;

@Repository
public interface ShipRepository extends JpaRepository<ShipEntity, BigInteger> {
}
