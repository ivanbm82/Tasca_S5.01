package cat.itacademy.barcelonactiva.Bueno.Martin.Ivan.s05.t01.n03.model.service;

import cat.itacademy.barcelonactiva.Bueno.Martin.Ivan.s05.t01.n03.model.dto.FlorDTO;
import cat.itacademy.barcelonactiva.Bueno.Martin.Ivan.s05.t01.n03.model.respository.FlorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlorServicesImpl implements FlorServices {
    private final FlorRepository florRepository;

    public FlorServicesImpl(FlorRepository florRepository) {
        this.florRepository = florRepository;
    }

    public void add(FlorDTO florDTO) {
        florRepository.add(florDTO);
    }

    public Optional<FlorDTO> getById(Integer id) {
        return florRepository.getById(id);
    }

    public List<FlorDTO> getAll() {
        return florRepository.getAll();
    }

    public boolean delete(Integer id) {
        Optional<FlorDTO> existingFlor = getById(id);
        if (existingFlor.isPresent()) {
            florRepository.delete(id);
            return true;
        }
        return false;
    }

    public boolean update(FlorDTO florDTO) {
        Integer id = florDTO.getPk_FlorID();
        Optional<FlorDTO> existingFlor = getById(id);
        if (existingFlor.isPresent()) {
            florRepository.update(florDTO);
            return true;
        }
        return false;
    }
}
