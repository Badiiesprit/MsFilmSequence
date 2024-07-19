package tn.esprit.dto;

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
    private Long filmId;
}
