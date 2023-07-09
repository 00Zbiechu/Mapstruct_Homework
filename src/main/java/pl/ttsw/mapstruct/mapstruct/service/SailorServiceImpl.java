package pl.ttsw.mapstruct.mapstruct.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.ttsw.mapstruct.mapstruct.dto.SailorDTO;
import pl.ttsw.mapstruct.mapstruct.entity.SailorEntity;
import pl.ttsw.mapstruct.mapstruct.mapper.SailorMapper;
import pl.ttsw.mapstruct.mapstruct.model.Sailors;
import pl.ttsw.mapstruct.mapstruct.repository.SailorRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SailorServiceImpl implements SailorService {

    private final SailorRepository sailorRepository;

    @Override
    public Sailors get() {

        List<SailorDTO> sailors = sailorRepository.findAll().stream()
                .map(SailorMapper.INSTANCE::toDTO)
                .toList();

        return Sailors.builder().sailors(sailors).build();

    }

    @Override
    public SailorDTO save(SailorDTO sailorDTO) {

        SailorEntity sailorEntity = SailorMapper.INSTANCE.toEntity(sailorDTO);

        sailorRepository.save(sailorEntity);

        return sailorDTO;

    }

}
