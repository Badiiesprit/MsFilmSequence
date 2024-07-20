package tn.esprit.msfilm.Dto;

import lombok.*;

import java.util.List;
import tn.esprit.dto.SequenceDTO;
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class FilmDTO {
    private Long id;
    private String name;
    private String description;
    private List<SequenceDTO> sequences;
}
