package tn.esprit.mssequence.Clients;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import tn.esprit.dto.FilmDTO;
import tn.esprit.mssequence.Config.FeignConfig;

//@FeignClient(name = "Ms-Film", configuration = FeignConfig.class)
@FeignClient(name = "ms-film", url="http://localhost:9099")
public interface FilmClient {
    Logger logger = LoggerFactory.getLogger(FilmClient.class);

    @GetMapping("/films/{id}")
    @CircuitBreaker(name = "filmService", fallbackMethod = "getFilmByIdFallback")
    FilmDTO getFilmById(@PathVariable("id") String id);

    default FilmDTO getFilmByIdFallback(String id, Throwable t) {
        logger.error("Fallback triggered for getFilmById with id {}: {}", id, t.getMessage());

        FilmDTO defaultFilm = new FilmDTO();
        defaultFilm.setId(Long.valueOf(id));
        defaultFilm.setName("Default Film Name");
        defaultFilm.setDescription("Film Service is not running or Broken");
        return defaultFilm;
    }
}
