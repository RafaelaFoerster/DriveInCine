package br.edu.ufape.poo.driveincine.dados;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ufape.poo.driveincine.negocio.basica.Cinema;

@Repository
public interface InterfaceColecaoCinema 
	extends JpaRepository<Cinema, Long>{

}