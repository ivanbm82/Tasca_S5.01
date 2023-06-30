package cat.itacademy.barcelonactiva.Bueno.Martin.Ivan.s05.t01.n03.model.service;

import cat.itacademy.barcelonactiva.Bueno.Martin.Ivan.s05.t01.n03.model.dto.FlorDTO;

import java.util.List;
import java.util.Optional;

public interface FlorServices {
    void add(FlorDTO florDTO);
    Optional<FlorDTO> getById(Integer id);
    List<FlorDTO> getAll();
    boolean delete(Integer id);
    boolean update(FlorDTO florDTO);
}
