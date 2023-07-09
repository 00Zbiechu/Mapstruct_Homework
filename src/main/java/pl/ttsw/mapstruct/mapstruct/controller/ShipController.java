package pl.ttsw.mapstruct.mapstruct.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.ttsw.mapstruct.mapstruct.dto.ShipDTO;
import pl.ttsw.mapstruct.mapstruct.model.Ships;
import pl.ttsw.mapstruct.mapstruct.service.ShipService;

@RestController
@RequestMapping("/api/ship")
@RequiredArgsConstructor
public class ShipController {

    private final ShipService shipService;

    @GetMapping
    public ResponseEntity<Ships> get() {

        return new ResponseEntity<>(shipService.get(), HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody ShipDTO shipDTO) {

        shipService.save(shipDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);

    }

}
