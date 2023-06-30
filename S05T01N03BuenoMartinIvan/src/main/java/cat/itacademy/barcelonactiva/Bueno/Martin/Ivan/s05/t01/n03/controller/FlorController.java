package cat.itacademy.barcelonactiva.Bueno.Martin.Ivan.s05.t01.n03.controller;

import cat.itacademy.barcelonactiva.Bueno.Martin.Ivan.s05.t01.n03.model.dto.FlorDTO;
import cat.itacademy.barcelonactiva.Bueno.Martin.Ivan.s05.t01.n03.model.service.FlorServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/flor")
public class FlorController {

    private final FlorServices florServices;

    public FlorController(FlorServices florServices) {
        this.florServices = florServices;
    }

    @PostMapping
    public ResponseEntity<String> addFlor(@RequestBody FlorDTO florDTO) {
        florServices.add(florDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Flor agregada exitosamente");
    }

    @GetMapping("/{id}")
    public ResponseEntity<FlorDTO> getFlorById(@PathVariable Integer id) {
        Optional<FlorDTO> florDTO = florServices.getById(id);
        return florDTO.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<FlorDTO>> getAllFlores() {
        List<FlorDTO> flores = florServices.getAll();
        return ResponseEntity.ok(flores);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteFlor(@PathVariable Integer id) {
        florServices.delete(id);
        return ResponseEntity.ok("Flor borrada exitosamente");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateFlor(@PathVariable Integer id, @RequestBody FlorDTO florDTO) {
        florDTO.setPk_FlorID(id);
        florServices.update(florDTO);
        return ResponseEntity.ok("Flor actualizada exitosamente");
    }
}
