package com.example.msfilm.Services;


import com.example.msfilm.Dto.FilmDTO;
import com.example.msfilm.Dto.FilmMapper;
import com.example.msfilm.Entities.Film;
import com.example.msfilm.Repositories.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FilmService {

    @Autowired
    private FilmRepository filmRepository;

    public List<FilmDTO> getAllFilms() {
        return filmRepository.findAll().stream()
                .map(FilmMapper::mapToDTO)
                .collect(Collectors.toList());
    }

    public Optional<FilmDTO> getFilmById(Long id) {
        return filmRepository.findById(id)
                .map(FilmMapper::mapToDTO);
    }

    public FilmDTO createFilm(FilmDTO filmDTO) {
        Film film = FilmMapper.mapToFilm(filmDTO);
        Film savedFilm = filmRepository.save(film);
        return FilmMapper.mapToDTO(savedFilm);
    }

    public FilmDTO updateFilm(Long id, FilmDTO filmDetails) {
        Film film = filmRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Film not found"));
        film.setName(filmDetails.getName());
        film.setDescription(filmDetails.getDescription());
        Film updatedFilm = filmRepository.save(film);
        return FilmMapper.mapToDTO(updatedFilm);
    }

    public void deleteFilm(Long id) {
        filmRepository.deleteById(id);
    }
}