package tn.esprit.mssequence.Repositories;

import tn.esprit.mssequence.Entities.Sequence;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface SequenceRepository extends MongoRepository<Sequence, String> {
    List<Sequence> findByFilmId(Long filmId);
}
