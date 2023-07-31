package br.edu.ufape.poo.driveincine.dados;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.edu.ufape.poo.driveincine.negocio.basica.Sessao;

@Repository
public interface InterfaceColecaoSessao extends JpaRepository<Sessao, Long> {
    
}

