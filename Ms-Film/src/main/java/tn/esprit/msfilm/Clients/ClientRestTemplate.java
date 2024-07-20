package tn.esprit.msfilm.Clients;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import tn.esprit.dto.SequenceDTO;

import java.util.List;

@Component
public class ClientRestTemplate {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${sequence.service.url}")
    private String sequenceServiceUrl;

    public List<SequenceDTO> getSequenceByIdFilm(String filmId) {
        String url = sequenceServiceUrl + "/sequences/film/" + filmId;
        return restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<SequenceDTO>>() {}).getBody();
    }
}
