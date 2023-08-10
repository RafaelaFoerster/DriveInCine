package br.edu.ufape.poo.driveincine.dados;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ufape.poo.driveincine.negocio.basica.Ingresso;

public interface InterfaceColecaoIngresso extends JpaRepository<Ingresso, Long>{

}
