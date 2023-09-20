package com.portafolio.Domain.Service;

import com.portafolio.Domain.Models.Portafolio;
import com.portafolio.Repositories.PortafolioRepositori;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PortafolioService {

    private final PortafolioRepositori portafolioRepositori;
    @Autowired
    public PortafolioService(PortafolioRepositori portafolioRepositori) {

        this.portafolioRepositori = portafolioRepositori;
    }

    public List<Portafolio> getPortafolio(){

        return portafolioRepositori.findAll();
    }

    public void newPortafolio(Portafolio portafolio) {
        portafolioRepositori.save(portafolio);
    }
    public Portafolio portafolioById(Integer id) {
        Optional<Portafolio> portafolioByID = (portafolioRepositori.findById(id));
        return portafolioByID.orElse(null);
    }
    public void update(Integer id, Portafolio portafolio) {
        Portafolio portafolioExistente = portafolioById(id);

        if (portafolioExistente == null) {
            System.out.println("error");

        }
        portafolioExistente.setTitulo(portafolio.getTitulo());
        portafolioExistente.setImagen(portafolio.getImagen());
        portafolioExistente.setGit(portafolio.getGit());
        portafolioExistente.setDescripcion(portafolio.getDescripcion());

        portafolioRepositori.save(portafolioExistente);
    }


    public void delete(Integer id, Portafolio portafolio) {
        boolean existe = portafolioRepositori.existsById(id);
        if (existe) {
            portafolioRepositori.delete(portafolio);
        }
    }
}
