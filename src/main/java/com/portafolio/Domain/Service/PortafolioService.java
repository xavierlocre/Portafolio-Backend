package com.portafolio.Domain.Service;

import com.portafolio.Domain.Models.Portafolio;
import com.portafolio.Repositories.PortafolioRepositori;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PortafolioService {

    private final PortafolioRepositori PortafolioRepositori;

    @Autowired

    public PortafolioService(com.portafolio.Repositories.PortafolioRepositori portafolioRepositori) {
        PortafolioRepositori = portafolioRepositori;
    }


    public List<Portafolio> getFormulario(){
        return PortafolioRepositori.findAll();
    }

    public void newPortafolio(Portafolio portafolio) {
        PortafolioRepositori.save(portafolio);
    }

    public void update(Integer id, Portafolio portafolio) {
        Optional<Portafolio> portafolioById = PortafolioRepositori.findById(id);

        if (portafolioById.isPresent()){
            Portafolio PortafolioExistente = portafolioById.get();

            PortafolioExistente.setTitulo(portafolio.getTitulo());
            PortafolioExistente.setFoto(portafolio.getFoto());
            PortafolioExistente.setGit(portafolio.getGit());
            PortafolioExistente.setDescripcion(portafolio.getDescripcion());

            PortafolioRepositori.save(PortafolioExistente);
        }
    }

    public void deletePortafolio(Integer id, Portafolio portafolio) {
        boolean existe = PortafolioRepositori.existsById(id);
        if (existe) {
            PortafolioRepositori.delete(portafolio);
        }
    }
}
