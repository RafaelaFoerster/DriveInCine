package br.edu.ufape.poo.driveincine.dados;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.edu.ufape.poo.driveincine.negocio.basica.Sessao;

@Repository
public interface InterfaceColecaoSessao extends JpaRepository<Sessao, Long> {

	List<Sessao> findByHorarioAndDiaExibicao(float horario, String diaExibicao);
	
    
}

