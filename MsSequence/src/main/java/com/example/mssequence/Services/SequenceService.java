package com.example.mssequence.Services;

import com.example.mssequence.Dto.SequenceDTO;
import com.example.mssequence.Dto.SequenceMapper;
import com.example.mssequence.Entities.Sequence;
import com.example.mssequence.Repositories.SequenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SequenceService {

    @Autowired
    private SequenceRepository sequenceRepository;

//    @Autowired
//    private FilmServiceClient filmServiceClient;

    public List<SequenceDTO> getAllSequences() {
        return sequenceRepository.findAll().stream()
                .map(SequenceMapper::mapToDTO)
                .collect(Collectors.toList());
    }

    public Optional<SequenceDTO> getSequenceById(String id) {
        return sequenceRepository.findById(id)
                .map(SequenceMapper::mapToDTO);
    }

    public List<SequenceDTO> getSequencesByFilmId(Long filmId) {
        return sequenceRepository.findByFilmId(filmId).stream()
                .map(SequenceMapper::mapToDTO)
                .collect(Collectors.toList());
    }

    public SequenceDTO createSequence(SequenceDTO sequenceDTO) {
//        FilmDTO film = filmServiceClient.getFilmById(sequenceDTO.getFilmId());
//        if (film == null) {
//            throw new RuntimeException("Film not found");
//        }
        Sequence sequence = SequenceMapper.mapToSequence(sequenceDTO);
        Sequence savedSequence = sequenceRepository.save(sequence);
        return SequenceMapper.mapToDTO(savedSequence);
    }

    public SequenceDTO updateSequence(String id, SequenceDTO sequenceDetails) {
        Sequence sequence = sequenceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sequence not found"));
//        FilmDTO film = filmServiceClient.getFilmById(sequenceDetails.getFilmId());
//        if (film == null) {
//            throw new RuntimeException("Film not found");
//        }
        sequence.setName(sequenceDetails.getName());
        sequence.setDescription(sequenceDetails.getDescription());
        sequence.setFilmId(sequenceDetails.getFilmId());
        Sequence updatedSequence = sequenceRepository.save(sequence);
        return SequenceMapper.mapToDTO(updatedSequence);
    }

    public void deleteSequence(String id) {
        sequenceRepository.deleteById(id);
    }
}