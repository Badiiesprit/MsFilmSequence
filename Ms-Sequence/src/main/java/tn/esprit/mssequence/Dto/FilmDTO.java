package tn.esprit.mssequence.Dto;

import lombok.*;

import java.util.List;

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
