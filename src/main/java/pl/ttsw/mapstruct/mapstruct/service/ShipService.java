package pl.ttsw.mapstruct.mapstruct.service;

import pl.ttsw.mapstruct.mapstruct.dto.ShipDTO;
import pl.ttsw.mapstruct.mapstruct.model.Ships;

import java.util.List;

public interface ShipService {


    Ships get();

    void save(ShipDTO shipDTO);
}
