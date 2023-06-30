package cat.itacademy.barcelonactiva.Bueno.Martin.Ivan.s05.t01.n02.model.services;

import cat.itacademy.barcelonactiva.Bueno.Martin.Ivan.s05.t01.n02.model.domain.FlorEntity;
import cat.itacademy.barcelonactiva.Bueno.Martin.Ivan.s05.t01.n02.model.dto.FlorDTO;
import cat.itacademy.barcelonactiva.Bueno.Martin.Ivan.s05.t01.n02.model.respository.FlorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FlorServicesImpl implements FlorServices {

    private final FlorRepository florRepository;

    @Autowired
    public FlorServicesImpl(FlorRepository florRepository) {
        this.florRepository = florRepository;
    }

    @Override
    public void add(FlorDTO florDTO) {
        if (isValidFlorDTO(florDTO)) {
            FlorEntity flor = convertToEntity(florDTO);
            florRepository.save(flor);
        }
    }

    @Override
    public List<FlorDTO> getAll() {
        List<FlorEntity> flores = florRepository.findAll();
        return flores.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (isValidId(id)) {
            florRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("La ID de la flor es inválida");
        }
    }

    @Override
    public Optional<FlorDTO> getById(Integer id) {
        if (isValidId(id)) {
            return florRepository.findById(id).map(this::convertToDTO);
        }
        return Optional.empty();
    }

    @Override
    public void update(FlorDTO florDTO) {
        if (isValidFlorDTO(florDTO)) {
            Integer id = florDTO.getPk_FlorID();
            if (isValidId(id)) {
                FlorEntity flor = florRepository.findById(id).orElse(null);
                if (flor != null) {
                    flor.setNomFlor(florDTO.getNomFlor());
                    flor.setPaisFlor(florDTO.getPaisFlor());
                    florRepository.save(flor);
                } else {
                    throw new IllegalArgumentException("No se encontró la flor con la ID especificada");
                }
            } else {
                throw new IllegalArgumentException("La ID de la flor es inválida");
            }
        }
    }

    private FlorDTO convertToDTO(FlorEntity flor) {
        FlorDTO florDTO = new FlorDTO();
        florDTO.setPk_FlorID(flor.getPk_FlorID());
        florDTO.setNomFlor(flor.getNomFlor());
        florDTO.setPaisFlor(flor.getPaisFlor());
        florDTO.setTipusFlor(getTipusFlor(flor.getPaisFlor()));
        return florDTO;
    }

    private FlorEntity convertToEntity(FlorDTO florDTO) {
        FlorEntity flor = new FlorEntity();
        flor.setNomFlor(florDTO.getNomFlor());
        flor.setPaisFlor(florDTO.getPaisFlor());
        return flor;
    }

    private String getTipusFlor(String pais) {
        List<String> paisesUE = getEUCountries();
        return paisesUE.contains(pais) ? "UE" : "Fora UE";
    }

    private List<String> getEUCountries() {
        return List.of(
                "Alemania", "Bélgica", "Croacia", "Dinamarca", "España", "Francia", "Irlanda", "Letonia", "Luxemburgo",
                "Países Bajos", "Suecia", "Bulgaria", "Eslovaquia", "Estonia", "Grecia", "Malta", "Polonia", "República Checa",
                "Austria", "Chipre", "Eslovenia", "Finlandia", "Hungría", "Italia", "Lituania", "Portugal", "Rumanía"
        );
    }

    private boolean isValidFlorDTO(FlorDTO florDTO) {
        if (florDTO == null || StringUtils.isEmpty(florDTO.getNomFlor()) || StringUtils.isEmpty(florDTO.getPaisFlor())) {
            return false;
        }
        return true;
    }

    private boolean isValidId(Integer id) {
        return id != null && id > 0;
    }
}
