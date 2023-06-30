package cat.itacademy.barcelonactiva.buenomartin.ivan.s05.t01.n01.model.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cat.itacademy.barcelonactiva.buenomartin.ivan.s05.t01.n01.model.domain.Sucursal;
import cat.itacademy.barcelonactiva.buenomartin.ivan.s05.t01.n01.model.dto.SucursalDTO;
import cat.itacademy.barcelonactiva.buenomartin.ivan.s05.t01.n01.model.repository.SucursalRepository;

@Service
public class SucursalServicesImpl implements SucursalServices{

    @Autowired
    private SucursalRepository sucursalRepository;

    @Override
    public List<SucursalDTO> getAllSucursal() {

        List<Sucursal> sucursales = sucursalRepository.findAll();
        List<SucursalDTO> sucursalDTOs = new ArrayList<>();
        for (Sucursal sucursal : sucursales) {
            sucursalDTOs.add(convertToDTO(sucursal));
        }
        return sucursalDTOs;
    }

    @Override
    public void addSucursal(SucursalDTO sucursalDTO) {
        Sucursal sucursal= new Sucursal();

        sucursal.setNomSucursal(sucursalDTO.getNomSucursal());
        sucursal.setPaisSucursal(sucursalDTO.getPaisSucursal());
        sucursalRepository.save(sucursal);

    }

    @Override
    public void delete(Integer id) {
        // TODO Auto-generated method stub
        sucursalRepository.deleteById(id);


    }

    @Override
    public SucursalDTO getSucursalById(Integer id) {
        Sucursal sucursal=sucursalRepository.findById(id).orElse(null);
        if (sucursal!= null) {
            return convertToDTO(sucursal);
        }
        return null;
    }

    @Override
    public void updateSucursal(SucursalDTO sucursalDTO) {

        Sucursal sucursal = sucursalRepository.findById(sucursalDTO.getPk_SucursalID()).orElse(null);
        if (sucursal != null) {
            sucursal.setNomSucursal(sucursalDTO.getNomSucursal());
            sucursal.setPaisSucursal(sucursalDTO.getPaisSucursal());
            sucursalRepository.save(sucursal);
        }
    }
    private SucursalDTO convertToDTO(Sucursal sucursal) {
        SucursalDTO sucursalDTO = new SucursalDTO();
        sucursalDTO.setPk_SucursalID(sucursal.getPk_SucursalID());
        sucursalDTO.setNomSucursal(sucursal.getNomSucursal());
        sucursalDTO.setPaisSucursal(sucursal.getPaisSucursal());
        sucursalDTO.setTipusSucursal(getTipusSucursal(sucursal.getPaisSucursal()));
        return sucursalDTO;
    }
    private String getTipusSucursal(String pais) {
        List<String> paisesUE = getEUCountries();
        if (paisesUE.contains(pais)) {
            return "UE";
        } else {
            return "Fora UE";
        }
    }
    private List<String> getEUCountries() {
        List<String> euCountries = new ArrayList<>(Arrays.asList(
                "Alemania", "Bélgica", "Croacia", "Dinamarca", "España", "Francia", "Irlanda", "Letonia", "Luxemburgo",
                "Países Bajos", "Suecia", "Bulgaria", "Eslovaquia", "Estonia", "Grecia", "Malta", "Polonia", "República Checa",
                "Austria", "Chipre", "Eslovenia", "Finlandia", "Hungría", "Italia", "Lituania", "Portugal", "Rumanía"
        ));
        return euCountries;
    }


}