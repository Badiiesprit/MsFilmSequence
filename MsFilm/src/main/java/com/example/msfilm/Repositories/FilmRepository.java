package com.example.msfilm.Repositories;


import com.example.msfilm.Entities.Film;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmRepository extends JpaRepository<Film, Long> {
}
