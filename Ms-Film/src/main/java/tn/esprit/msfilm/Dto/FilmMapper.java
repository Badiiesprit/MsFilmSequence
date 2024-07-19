package tn.esprit.msfilm.Dto;

import tn.esprit.msfilm.Entities.Film;
import tn.esprit.dto.FilmDTO;
public class FilmMapper {

    public static Film mapToFilm(FilmDTO filmDTO) {
        if (filmDTO == null) {
            return null;
        }

        Film film = new Film();
        film.setId(filmDTO.getId());
        film.setName(filmDTO.getName());
        film.setDescription(filmDTO.getDescription());
        return film;
    }

    public static FilmDTO mapToDTO(Film film) {
        if (film == null) {
            return null;
        }

        FilmDTO filmDTO = new FilmDTO();
        filmDTO.setId(film.getId());
        filmDTO.setName(film.getName());
        filmDTO.setDescription(film.getDescription());
        return filmDTO;
    }
}