package cat.itacademy.barcelonactiva.Bueno.Martin.Ivan.s05.t01.n03;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import cat.itacademy.barcelonactiva.Bueno.Martin.Ivan.s05.t01.n03.model.dto.FlorDTO;
import cat.itacademy.barcelonactiva.Bueno.Martin.Ivan.s05.t01.n03.model.respository.FlorRepository;
import cat.itacademy.barcelonactiva.Bueno.Martin.Ivan.s05.t01.n03.model.service.FlorServicesImpl;

@RunWith(MockitoJUnitRunner.class)
public class FlorServicesImplTests {

    @InjectMocks
    private FlorServicesImpl florServices;

    @Mock
    private FlorRepository florRepository;

    @Test
    public void testAdd_AddsFlorToRepository() {

    	FlorDTO florDTO = new FlorDTO();

        florServices.add(florDTO);

        verify(florRepository).add(florDTO);
    }

    @Test
    public void testGetById_WithValidId_ReturnsOptionalFlorDTO() {
        Integer id = 1;
        
        FlorDTO florDTO = new FlorDTO();
        
        when(florRepository.getById(id)).thenReturn(Optional.of(florDTO));

        Optional<FlorDTO> result = florServices.getById(id);

        assertTrue(result.isPresent());
        assertEquals(florDTO, result.get());
    }

    @Test
    public void testGetById_WithInvalidId_ReturnsEmptyOptional() {
        Integer id = 999;
        when(florRepository.getById(id)).thenReturn(Optional.empty());

        Optional<FlorDTO> result = florServices.getById(id);

        assertFalse(result.isPresent());
    }

}
