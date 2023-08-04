package br.edu.ufape.poo.driveincine.dados;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ufape.poo.driveincine.negocio.basica.Compra;

public interface InterfaceColecaoCompra extends JpaRepository<Compra, Long> {
	
}
