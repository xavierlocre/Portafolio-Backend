package com.portafolio.Repositories;

import com.portafolio.Domain.Models.Portafolio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PortafolioRepositori extends JpaRepository<Portafolio, Integer> {
}
