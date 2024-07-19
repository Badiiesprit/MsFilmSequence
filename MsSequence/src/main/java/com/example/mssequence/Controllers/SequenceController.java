package com.example.mssequence.Controllers;

import com.example.mssequence.Dto.SequenceDTO;
import com.example.mssequence.Services.SequenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sequences")
public class SequenceController {

    @Autowired
    private SequenceService sequenceService;

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
