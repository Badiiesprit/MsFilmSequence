package tn.esprit.dto;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class SequenceDTOGet {
    private String id;
    private String name;
    private String description;
    private String filmId;
    private FilmDTO film;
}
