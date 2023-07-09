package pl.ttsw.mapstruct.mapstruct.model;

import lombok.*;
import pl.ttsw.mapstruct.mapstruct.dto.ShipDTO;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Ships {

    List<ShipDTO> ships;

}
