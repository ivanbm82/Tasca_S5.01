package cat.itacademy.barcelonactiva.Bueno.Martin.Ivan.s05.t01.n02.controller;

import cat.itacademy.barcelonactiva.Bueno.Martin.Ivan.s05.t01.n02.model.dto.FlorDTO;
import cat.itacademy.barcelonactiva.Bueno.Martin.Ivan.s05.t01.n02.model.services.FlorServices;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/flor")
public class FlorController {

    private final FlorServices florServices;

    @Autowired
    public FlorController(FlorServices florServices) {
        this.florServices = florServices;
    }

    @Tag(name = "Agregar una flor")
    @ApiResponse(responseCode = "201", description = "Flor agregada exitosamente")
    @PostMapping
    public ResponseEntity<String> addFlor(@RequestBody FlorDTO florDTO) {
        florServices.add(florDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Flor agregada exitosamente");
    }
    @Tag(name = "Obtener por su ID")
    @ApiResponse(responseCode = "200", description = "Flor encontrada exitosamente", content = @Content(schema = @Schema(implementation = FlorDTO.class)))
    @GetMapping("/{id}")
    public ResponseEntity<FlorDTO> getFlorById(@PathVariable Integer id) {
        Optional<FlorDTO> florDTO = florServices.getById(id);
        return florDTO.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Tag(name = "Obtener todo")
    @GetMapping
    public ResponseEntity<List<FlorDTO>> getAllFlores() {
        List<FlorDTO> flores = florServices.getAll();
        return ResponseEntity.ok(flores);
    }

    @Tag(name = "Eliminar por ID")
    @ApiResponse(responseCode = "200", description = "Flor eliminada exitosamente")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteFlor(@PathVariable Integer id) {
        florServices.delete(id);
        return ResponseEntity.ok("Flor eliminada exitosamente");
    }

    @Tag(name = "Actualizar por ID")
    @ApiResponse(responseCode = "200", description = "Flor actualizada exitosamente")
    @PutMapping("/{id}")
    public ResponseEntity<String> updateFlor(@PathVariable Integer id, @RequestBody FlorDTO florDTO) {
        florDTO.setPk_FlorID(id);
        florServices.update(florDTO);
        return ResponseEntity.ok("Flor actualizada exitosamente");
    }
}
