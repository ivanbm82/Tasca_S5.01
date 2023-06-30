package cat.itacademy.barcelonactiva.Bueno.Martin.Ivan.s05.t01.n03.model.respository;

import cat.itacademy.barcelonactiva.Bueno.Martin.Ivan.s05.t01.n03.model.dto.FlorDTO;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;

@Repository
public class FlorRepository {
    private final WebClient webClient;

    public FlorRepository(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://localhost:9001").build();
    }

    public void add(FlorDTO florDTO) {
        webClient.post()
                .uri("/flor")
                .bodyValue(florDTO)
                .retrieve()
                .toBodilessEntity()
                .block();
    }

    public Optional<FlorDTO> getById(Integer id) {
        Mono<FlorDTO> response = webClient.get()
                .uri("/flor/{id}", id)
                .retrieve()
                .bodyToMono(FlorDTO.class);

        return Optional.ofNullable(response.block());
    }

    public List<FlorDTO> getAll() {
        Mono<List<FlorDTO>> response = webClient.get()
                .uri("/flor")
                .retrieve()
                .bodyToFlux(FlorDTO.class)
                .collectList();

        return response.block();
    }

    public void delete(Integer id) {
        webClient.delete()
                .uri("/flor/{id}", id)
                .retrieve()
                .toBodilessEntity()
                .block();
    }

    public void update(FlorDTO florDTO) {
        Integer id = florDTO.getPk_FlorID();

        webClient.put()
                .uri("/flor/{id}", id)
                .bodyValue(florDTO)
                .retrieve()
                .toBodilessEntity()
                .block();
    }
}
