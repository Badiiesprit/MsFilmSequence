package tn.esprit.mssequence.Dto;

import tn.esprit.mssequence.Entities.Sequence;
import tn.esprit.dto.SequenceDTO;
public class SequenceMapper {

    public static Sequence mapToSequence(SequenceDTO sequenceDTO) {
        if (sequenceDTO == null) {
            return null;
        }

        Sequence sequence = new Sequence();
        sequence.setId(sequenceDTO.getId());
        sequence.setName(sequenceDTO.getName());
        sequence.setDescription(sequenceDTO.getDescription());
        sequence.setFilmId(sequenceDTO.getFilmId());
        return sequence;
    }

    public static SequenceDTO mapToDTO(Sequence sequence) {
        if (sequence == null) {
            return null;
        }

        SequenceDTO sequenceDTO = new SequenceDTO();
        sequenceDTO.setId(sequence.getId());
        sequenceDTO.setName(sequence.getName());
        sequenceDTO.setDescription(sequence.getDescription());
        sequenceDTO.setFilmId(sequence.getFilmId());
        return sequenceDTO;
    }
}
