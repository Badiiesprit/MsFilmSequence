package tn.esprit.dto;

import lombok.*;

import java.util.List;
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class FilmDTOGet {
    private Long id;
    private String name;
    private String description;
    private List<SequenceDTO> sequences;
}
