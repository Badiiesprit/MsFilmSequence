package tn.esprit.dto;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class FilmDTO {
    private Long id;
    private String name;
    private String description;
}
