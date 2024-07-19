package tn.esprit.mssequence.Clients;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import tn.esprit.dto.FilmDTO;
import tn.esprit.mssequence.Config.FeignConfig;

@FeignClient(name = "ms-film",configuration = FeignConfig.class)
public interface FilmClient {
    Logger logger = LoggerFactory.getLogger(FilmClient.class);
    @GetMapping("/api/film/{filmId}")
    @CircuitBreaker(name = "filmService", fallbackMethod = "getFilmByIdFallback")
    FilmDTO getFilmById(@PathVariable("filmId") String filmId);
    default FilmDTO getFilmByIdFallback(String filmId, Throwable t) {

        logger.error("Fallback triggered for getFilmById with id {}: {}", filmId, t.getMessage());

        FilmDTO defaultFilm = new FilmDTO();
        defaultFilm.setId(Long.valueOf(filmId));
        defaultFilm.setName("Default Film Name");
        defaultFilm.setDescription("Film Service is not running or Broken");
        return defaultFilm;
    }
}