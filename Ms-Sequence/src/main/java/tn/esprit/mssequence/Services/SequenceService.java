package tn.esprit.mssequence.Services;

import tn.esprit.dto.FilmDTO;
import tn.esprit.dto.SequenceDTO;
import tn.esprit.mssequence.Clients.FilmClient;
import tn.esprit.mssequence.Dto.SequenceMapper;
import tn.esprit.mssequence.Entities.Sequence;
import tn.esprit.mssequence.Repositories.SequenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SequenceService {

    private final SequenceRepository sequenceRepository;
    private final FilmClient filmServiceClient;

    @Autowired
    public SequenceService(SequenceRepository sequenceRepository, FilmClient filmServiceClient) {
        this.sequenceRepository = sequenceRepository;
        this.filmServiceClient = filmServiceClient;
    }

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

    public FilmDTO getSequenceFilm(Long filmId) {
        FilmDTO film = filmServiceClient.getFilmById(String.valueOf(filmId));
        if (film == null) {
            throw new RuntimeException("Film not found");
        }
        return film;
    }

    public SequenceDTO createSequence(SequenceDTO sequenceDTO) {
        FilmDTO film = filmServiceClient.getFilmById(String.valueOf(sequenceDTO.getFilmId()));
        if (film == null) {
            throw new RuntimeException("Film not found");
        }

        Sequence sequence = SequenceMapper.mapToSequence(sequenceDTO);
        Sequence savedSequence = sequenceRepository.save(sequence);
        return SequenceMapper.mapToDTO(savedSequence);
    }

    public SequenceDTO updateSequence(String id, SequenceDTO sequenceDetails) {
        Sequence sequence = sequenceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sequence not found"));
        FilmDTO film = filmServiceClient.getFilmById(String.valueOf(sequenceDetails.getFilmId()));
        if (film == null) {
            throw new RuntimeException("Film not found");
        }
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

//public class SequenceService {
//
//    @Autowired
//    private SequenceRepository sequenceRepository;
//
////    @Autowired
//    private FilmClient filmServiceClient;
//
//    public List<SequenceDTO> getAllSequences() {
//        return sequenceRepository.findAll().stream()
//                .map(SequenceMapper::mapToDTO)
//                .collect(Collectors.toList());
//    }
//
//    public Optional<SequenceDTO> getSequenceById(String id) {
//        return sequenceRepository.findById(id)
//                .map(SequenceMapper::mapToDTO);
//    }
//
//    public List<SequenceDTO> getSequencesByFilmId(Long filmId) {
//        return sequenceRepository.findByFilmId(filmId).stream()
//                .map(SequenceMapper::mapToDTO)
//                .collect(Collectors.toList());
//    }
//    public FilmDTO getSequenceFilm(Long filmId) {
//        FilmDTO film = filmServiceClient.getFilmById(String.valueOf(filmId));
//        if (film == null) {
//            throw new RuntimeException("Film not found");
//        }
//        return film;
//    }
//    public SequenceDTO createSequence(SequenceDTO sequenceDTO) {
//        //try {
//            FilmDTO film = filmServiceClient.getFilmById(String.valueOf(sequenceDTO.getFilmId()));
//            if (film == null) {
//                throw new RuntimeException("Film not found");
//            }
////        }catch (Exception exception){
////            System.out.println(exception.getMessage());
////            throw new RuntimeException("Film not found22");
////        }
//
//        Sequence sequence = SequenceMapper.mapToSequence(sequenceDTO);
//        Sequence savedSequence = sequenceRepository.save(sequence);
//        return SequenceMapper.mapToDTO(savedSequence);
//    }
//
//
//    public SequenceDTO updateSequence(String id, SequenceDTO sequenceDetails) {
//        Sequence sequence = sequenceRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Sequence not found"));
//        FilmDTO film = filmServiceClient.getFilmById(String.valueOf(sequenceDetails.getFilmId()));
//        if (film == null) {
//            throw new RuntimeException("Film not found");
//        }
//        sequence.setName(sequenceDetails.getName());
//        sequence.setDescription(sequenceDetails.getDescription());
//        sequence.setFilmId(sequenceDetails.getFilmId());
//        Sequence updatedSequence = sequenceRepository.save(sequence);
//        return SequenceMapper.mapToDTO(updatedSequence);
//    }
//
//    public void deleteSequence(String id) {
//        sequenceRepository.deleteById(id);
//    }
//}