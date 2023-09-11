package com.portafolio.ApiController;

import com.portafolio.Domain.Models.Portafolio;
import com.portafolio.Domain.Service.PortafolioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/portfolio")

public class PortafolioController {

    private final PortafolioService PortafolioService;

    @Autowired

    public PortafolioController(com.portafolio.Domain.Service.PortafolioService portafolioService) {
        PortafolioService = portafolioService;
    }

    @GetMapping
    public List<Portafolio> getPortafolioService(){
        return PortafolioService.getFormulario();
    }

    @PostMapping
    public void createFormulario(@RequestBody Portafolio Portafolio){
        PortafolioService.newPortafolio(Portafolio);
    }

    @PutMapping("/{id}")
    public void updatePortafolio(@PathVariable Integer id, @RequestBody Portafolio Portafolio){
        PortafolioService.update(id, Portafolio);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id, Portafolio portafolio){
        PortafolioService.deletePortafolio(id, portafolio);
    }
}

