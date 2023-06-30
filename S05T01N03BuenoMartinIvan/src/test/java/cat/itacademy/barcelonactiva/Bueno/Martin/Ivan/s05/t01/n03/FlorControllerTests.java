package cat.itacademy.barcelonactiva.Bueno.Martin.Ivan.s05.t01.n03;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import cat.itacademy.barcelonactiva.Bueno.Martin.Ivan.s05.t01.n03.controller.FlorController;
import cat.itacademy.barcelonactiva.Bueno.Martin.Ivan.s05.t01.n03.model.dto.FlorDTO;
import cat.itacademy.barcelonactiva.Bueno.Martin.Ivan.s05.t01.n03.model.service.FlorServices;

@RunWith(MockitoJUnitRunner.class)
public class FlorControllerTests {

    @InjectMocks
    private FlorController florController;

    @Mock
    private FlorServices florServices;

    @Test
    public void testAddFlor_ReturnsCreatedStatus() {
        FlorDTO florDTO = new FlorDTO();

        ResponseEntity<String> response = florController.addFlor(florDTO);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals("Flor agregada exitosamente", response.getBody());
    }

    @Test
    public void testGetFlorById_WithValidId_ReturnsFlorDTO() {

    	Integer id = 1;
        FlorDTO florDTO = new FlorDTO();
        
        when(florServices.getById(id)).thenReturn(Optional.of(florDTO));

        ResponseEntity<FlorDTO> response = florController.getFlorById(id);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(florDTO, response.getBody());

    }

    @Test
    public void testGetFlorById_WithInvalidId_ReturnsNotFoundStatus() {

    	Integer id = 999;
        when(florServices.getById(id)).thenReturn(Optional.empty());

        ResponseEntity<FlorDTO> response = florController.getFlorById(id);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

}
