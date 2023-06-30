package cat.itacademy.barcelonactiva.Bueno.Martin.Ivan.s05.t01.n02.model.services;

    import cat.itacademy.barcelonactiva.Bueno.Martin.Ivan.s05.t01.n02.model.domain.FlorEntity;
    import cat.itacademy.barcelonactiva.Bueno.Martin.Ivan.s05.t01.n02.model.dto.FlorDTO;

    import java.util.List;
    import java.util.Optional;

public interface FlorServices {


    void add(FlorDTO florDTO);
    List<FlorDTO> getAll();
    void delete(Integer id);
    Optional<FlorDTO> getById(Integer id);
    void update(FlorDTO florDTO);
}
