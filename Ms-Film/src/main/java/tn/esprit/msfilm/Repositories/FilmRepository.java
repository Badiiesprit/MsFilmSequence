package tn.esprit.msfilm.Repositories;


import tn.esprit.msfilm.Entities.Film;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmRepository extends JpaRepository<Film, Long> {
}
