package br.edu.ufape.poo.driveincine.negocio.fachada;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufape.poo.driveincine.negocio.basica.Sessao;
import br.edu.ufape.poo.driveincine.negocio.basica.Vaga;
import br.edu.ufape.poo.driveincine.negocio.cadastro.InterfaceCadastroSessao;
import br.edu.ufape.poo.driveincine.negocio.cadastro.InterfaceCadastroVaga;
import br.edu.ufape.poo.driveincine.negocio.cadastro.excecoes.SessaoJaExistenteException;
import br.edu.ufape.poo.driveincine.negocio.cadastro.excecoes.SessaoNaoExisteException;
import br.edu.ufape.poo.driveincine.negocio.cadastro.excecoes.VagaNãoExisteException;
import br.edu.ufape.poo.driveincine.negocio.cadastro.excecoes.VagaOcupadaException;

@Service
public class Fachada {

    @Autowired
    private InterfaceCadastroSessao cadastroSessao;

    @Autowired
    private InterfaceCadastroVaga cadastroVaga;

    public Sessao procurarSessaoPeloId(long id) {
        return cadastroSessao.procurarSessaoPeloId(id);
    }

    public List<Sessao> listarTodasSessoes() {
        return cadastroSessao.listarTodasSessoes();
    }

    public void excluirSessao(long id) throws SessaoNaoExisteException {
        cadastroSessao.excluirSessao(id);
    }

    public List<Sessao> procurarSessoesPeloHorarioEData(float horario, String diaExibicao) {
        return cadastroSessao.procurarSessoesPeloHorarioEData(horario, diaExibicao);
    }

    public Sessao salvarSessao(Sessao sessao) throws SessaoJaExistenteException {
        return cadastroSessao.salvarSessao(sessao);
    }

    public Vaga procurarVagaPeloId(long id) {
        return cadastroVaga.procurarVagaPeloId(id);
    }
    public Vaga salvarVaga(Vaga vaga, long sessaoId) throws SessaoNaoExisteException {
    	return cadastroVaga.salvarVaga(vaga, sessaoId);
    }
    public void removerVaga(Long id) throws VagaNãoExisteException {
        cadastroVaga.removerVagaPorId(id);
    }

    public Vaga atualizarStatusVaga(long id, boolean ocupado) throws VagaOcupadaException {
        return cadastroVaga.atualizarStatusVaga(id, ocupado);
    }


}


