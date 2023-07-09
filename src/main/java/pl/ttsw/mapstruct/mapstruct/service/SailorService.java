package pl.ttsw.mapstruct.mapstruct.service;

import pl.ttsw.mapstruct.mapstruct.dto.SailorDTO;
import pl.ttsw.mapstruct.mapstruct.model.Sailors;

public interface SailorService {

    Sailors get();

    SailorDTO save(SailorDTO sailorDTO);

}
