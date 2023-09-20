package com.portafolio.ApiController;

import com.portafolio.Domain.Models.Portafolio;
import com.portafolio.Domain.Service.PortafolioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



import java.util.List;

@RestController
@CrossOrigin( origins = "http://localhost:5173/")
@RequestMapping(path = "api/v1/portfolio")

public class PortafolioController {

    private final PortafolioService PortafolioService;

    @Autowired

    public PortafolioController(PortafolioService portafolioService) {
        this.PortafolioService = portafolioService;
    }
    @GetMapping
    public List <Portafolio> getPortafolioController(){
        return PortafolioService.getPortafolio();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Portafolio> getPortafolioPorId(@PathVariable Integer id) {
        // Lógica para obtener la cita por ID y devolverla en la respuesta ResponseEntity
        Portafolio cita = PortafolioService.portafolioById(id);
        if (cita != null ) {
            return ResponseEntity.ok(cita);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public void createPortafolio(@RequestBody Portafolio portafolio){
        PortafolioService.newPortafolio(portafolio);
    }

    @PutMapping("/{id}")
    public void updatePortafolio(@PathVariable Integer id, @RequestBody Portafolio portafolio){
        PortafolioService.update(id, portafolio);
    }

    @DeleteMapping("/{id}")
    public void  deletePortafolio(@PathVariable Integer id, Portafolio portafolio){
        PortafolioService.delete(id, portafolio);
    }
}

