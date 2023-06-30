package cat.itacademy.barcelonactiva.buenomartin.ivan.s05.t01.n01.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import cat.itacademy.barcelonactiva.buenomartin.ivan.s05.t01.n01.model.dto.SucursalDTO;
import cat.itacademy.barcelonactiva.buenomartin.ivan.s05.t01.n01.model.services.SucursalServices;

@Controller
@RequestMapping(value={"/sucursal", "/sucursal/"})
public class SucursalController {
    @Autowired
    private SucursalServices sucursalService;


    @GetMapping()
    public String sucursalCentral() {
    return "sucursal_central";
    }
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("sucursal", new SucursalDTO());
        return "add-sucursal";
    }

    @PostMapping("/add")
    public String addSucursal(@ModelAttribute("sucursal") SucursalDTO sucursalDTO) {
        sucursalService.addSucursal(sucursalDTO);
        return "redirect:/sucursal/getAll";
    }

    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
        SucursalDTO sucursalDTO = sucursalService.getSucursalById(id);

        model.addAttribute("sucursal", sucursalDTO);
        return "update-sucursal";
    }

    @PostMapping("/update")
    public String updateSucursal(@ModelAttribute("sucursal") SucursalDTO sucursalDTO) {
        sucursalService.updateSucursal(sucursalDTO);
        return "redirect:/sucursal/getAll";
    }

    @GetMapping("/delete/{id}")
    public String deleteSucursal(@PathVariable("id") Integer id) {
        sucursalService.delete(id);
        return "redirect:/sucursal/getAll";
    }

    @GetMapping("/getOne/{id}")
    public String getSucursal(@PathVariable("id") Integer id, Model model) {
        SucursalDTO sucursalDTO = sucursalService.getSucursalById(id);
        model.addAttribute("sucursal", sucursalDTO);
        return "get-sucursal";
    }

    @GetMapping("/getAll")
    public String getAllSucursales(Model model) {
        List<SucursalDTO> sucursalDTOs = sucursalService.getAllSucursal();
        model.addAttribute("sucursales", sucursalDTOs);
        return "sucursales";
    }
}