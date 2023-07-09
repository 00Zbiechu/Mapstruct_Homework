package pl.ttsw.mapstruct.mapstruct.model;

import lombok.*;
import pl.ttsw.mapstruct.mapstruct.dto.SailorDTO;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Sailors {

    private List<SailorDTO> sailors;

}
