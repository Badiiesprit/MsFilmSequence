package tn.esprit.msfilm.Controllers;

//import tn.esprit.msfilm.Dto.FilmDTO;
import tn.esprit.dto.FilmDTO;
import tn.esprit.msfilm.Services.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/films")
public class FilmController {

    @Autowired
    private FilmService filmService;

    @GetMapping
    public List<FilmDTO> getAllFilms() {
        return filmService.getAllFilms();
    }

    @GetMapping("/{id}")
    public ResponseEntity<FilmDTO> getFilmById(@PathVariable Long id) {
        FilmDTO film = filmService.getFilmById(id)
                .orElseThrow(() -> new RuntimeException("Film not found"));
        return ResponseEntity.ok(film);
    }

    @PostMapping
    public FilmDTO createFilm(@RequestBody FilmDTO film) {
        return filmService.createFilm(film);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FilmDTO> updateFilm(@PathVariable Long id, @RequestBody FilmDTO filmDetails) {
        FilmDTO updatedFilm = filmService.updateFilm(id, filmDetails);
        return ResponseEntity.ok(updatedFilm);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFilm(@PathVariable Long id) {
        filmService.deleteFilm(id);
        return ResponseEntity.noContent().build();
    }
}
