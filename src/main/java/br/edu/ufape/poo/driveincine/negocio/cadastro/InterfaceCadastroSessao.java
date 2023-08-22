package br.edu.ufape.poo.driveincine.negocio.cadastro;

import br.edu.ufape.poo.driveincine.negocio.basica.Sessao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

public interface InterfaceCadastroSessao {

    Sessao procurarSessaoPeloId(long id);

    List<Sessao> listarTodasSessoes();

    void excluirSessao(Sessao sessao);

    Sessao salvarSessao(Sessao sessao);
    
    List<Sessao> findByHorarioAndDiaExibicao(float horario, String diaExibicao);
}
