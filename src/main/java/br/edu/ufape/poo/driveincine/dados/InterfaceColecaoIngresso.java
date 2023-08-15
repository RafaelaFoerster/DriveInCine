package br.edu.ufape.poo.driveincine.dados;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import br.edu.ufape.poo.driveincine.negocio.basica.Ingresso;
@Repository
public interface InterfaceColecaoIngresso extends JpaRepository<Ingresso, Long>{

}
