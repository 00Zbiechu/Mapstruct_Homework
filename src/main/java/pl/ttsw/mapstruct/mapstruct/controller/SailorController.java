package pl.ttsw.mapstruct.mapstruct.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.ttsw.mapstruct.mapstruct.dto.SailorDTO;
import pl.ttsw.mapstruct.mapstruct.model.Sailors;
import pl.ttsw.mapstruct.mapstruct.service.SailorService;

@RestController
@RequestMapping("/api/sailor")
@RequiredArgsConstructor
public class SailorController {

    private final SailorService sailorService;

    @GetMapping
    public ResponseEntity<Sailors> get() {

        return new ResponseEntity<>(sailorService.get(), HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity<SailorDTO> create(@RequestBody SailorDTO sailorDTO) {

        return new ResponseEntity<>(sailorService.save(sailorDTO), HttpStatus.CREATED);

    }

}
