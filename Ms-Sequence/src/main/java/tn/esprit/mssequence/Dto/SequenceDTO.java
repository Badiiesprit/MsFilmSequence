package tn.esprit.mssequence.Dto;

import lombok.*;
import tn.esprit.dto.FilmDTO;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class SequenceDTO {
    private String id;
    private String name;
    private String description;
    private String filmId;
    private FilmDTO film;
}
