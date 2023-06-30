package cat.itacademy.barcelonactiva.buenomartin.ivan.s05.t01.n01.model.services;


import cat.itacademy.barcelonactiva.buenomartin.ivan.s05.t01.n01.model.dto.SucursalDTO;

import java.util.List;

public interface SucursalServices {

    List<SucursalDTO> getAllSucursal();

    void addSucursal(SucursalDTO sucursalDTO);

    void delete(Integer id);

    SucursalDTO getSucursalById(Integer id);

    void updateSucursal(SucursalDTO sucursalDTO);
}