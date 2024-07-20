package tn.esprit.mssequence.Controllers;

import tn.esprit.dto.FilmDTO;
import tn.esprit.mssequence.Clients.FilmClient;
import tn.esprit.dto.SequenceDTO;
import tn.esprit.mssequence.Services.SequenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sequences")
public class SequenceController {

    private final SequenceService sequenceService;

    @Autowired
    public SequenceController(SequenceService sequenceService) {
        this.sequenceService = sequenceService;
    }

    @GetMapping
    public List<SequenceDTO> getAllSequences() {
        return sequenceService.getAllSequences();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SequenceDTO> getSequenceById(@PathVariable String id) {
        SequenceDTO sequence = sequenceService.getSequenceById(id)
                .orElseThrow(() -> new RuntimeException("Sequence not found"));
        return ResponseEntity.ok(sequence);
    }

    @GetMapping("/film/{filmId}")
    public List<SequenceDTO> getSequencesByFilmId(@PathVariable Long filmId) {
        return sequenceService.getSequencesByFilmId(filmId);
    }

    @GetMapping("/filmbyid/{filmId}")
    public FilmDTO getByFilmId(@PathVariable Long filmId) {
        return sequenceService.getSequenceFilm(filmId);
    }

    @PostMapping
    public SequenceDTO createSequence(@RequestBody SequenceDTO sequence) {
        return sequenceService.createSequence(sequence);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SequenceDTO> updateSequence(@PathVariable String id, @RequestBody SequenceDTO sequenceDetails) {
        SequenceDTO updatedSequence = sequenceService.updateSequence(id, sequenceDetails);
        return ResponseEntity.ok(updatedSequence);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSequence(@PathVariable String id) {
        sequenceService.deleteSequence(id);
        return ResponseEntity.noContent().build();
    }
}
//public class SequenceController {
//
//    @Autowired
//    private SequenceService sequenceService;
//
//    @Autowired
//    private FilmClient filmClient;
//    @GetMapping
//    public List<SequenceDTO> getAllSequences() {
//        return sequenceService.getAllSequences();
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<SequenceDTO> getSequenceById(@PathVariable String id) {
//        SequenceDTO sequence = sequenceService.getSequenceById(id)
//                .orElseThrow(() -> new RuntimeException("Sequence not found"));
//        tn.esprit.mssequence.Dto.SequenceDTO newsequence = new tn.esprit.mssequence.Dto.SequenceDTO();
//        newsequence.setId(sequence.getId());
//        newsequence.setName(sequence.getName());
//        newsequence.setDescription(sequence.getDescription());
//        newsequence.setFilmId(String.valueOf(sequence.getFilmId()));
//        newsequence.setFilm(filmClient.getFilmById(String.valueOf(sequence.getFilmId())));
//        return ResponseEntity.ok(sequence);
//    }
//
//    @GetMapping("/film/{filmId}")
//    public List<SequenceDTO> getSequencesByFilmId(@PathVariable Long filmId) {
//        return sequenceService.getSequencesByFilmId(filmId);
//    }
//    @GetMapping("/filmbyid/{filmId}")
//    public FilmDTO getByFilmId(@PathVariable Long filmId) {
//        return sequenceService.getSequenceFilm(filmId);
//    }
//
//
//    @PostMapping
//    public SequenceDTO createSequence(@RequestBody SequenceDTO sequence) {
//        return sequenceService.createSequence(sequence);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<SequenceDTO> updateSequence(@PathVariable String id, @RequestBody SequenceDTO sequenceDetails) {
//        SequenceDTO updatedSequence = sequenceService.updateSequence(id, sequenceDetails);
//        return ResponseEntity.ok(updatedSequence);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteSequence(@PathVariable String id) {
//        sequenceService.deleteSequence(id);
//        return ResponseEntity.noContent().build();
//    }
//}
