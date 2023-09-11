package br.edu.ufape.poo.driveincine.dados;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ufape.poo.driveincine.negocio.basica.Vaga;

@Repository
public interface InterfaceColecaoVaga extends JpaRepository<Vaga, Long> {

	List<Vaga> findBySessaoId(long idSessao);


    
}
