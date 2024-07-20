package tn.esprit.msfilm.Dto;

import lombok.*;

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
