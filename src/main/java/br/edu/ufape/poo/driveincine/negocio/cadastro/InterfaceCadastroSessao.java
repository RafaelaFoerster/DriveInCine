package br.edu.ufape.poo.driveincine.negocio.cadastro;

import java.util.List;

import br.edu.ufape.poo.driveincine.negocio.basica.Filme;
import br.edu.ufape.poo.driveincine.negocio.basica.Sessao;
import br.edu.ufape.poo.driveincine.negocio.cadastro.excecoes.SessaoJaExistenteException;
import br.edu.ufape.poo.driveincine.negocio.cadastro.excecoes.SessaoNaoExisteException;

public interface InterfaceCadastroSessao {

    Sessao procurarSessaoPeloId(long id);

    List<Sessao> listarTodasSessoes();

    void excluirSessao(long Id) throws SessaoNaoExisteException;

    List<Sessao> procurarSessoesPeloHorarioEData(float horario, String diaExibicao) throws SessaoNaoExisteException;

    Sessao salvarSessao(Sessao sessao) throws SessaoJaExistenteException, SessaoNaoExisteException;

	 List<Sessao> procurarSessoesPelofilme(Filme filme);

}
