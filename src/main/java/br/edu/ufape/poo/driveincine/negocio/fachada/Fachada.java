package br.edu.ufape.poo.driveincine.negocio.fachada;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import br.edu.ufape.poo.driveincine.negocio.basica.Ingresso;
import br.edu.ufape.poo.driveincine.negocio.basica.Sessao;
import br.edu.ufape.poo.driveincine.negocio.basica.Vaga;
import br.edu.ufape.poo.driveincine.negocio.cadastro.InterfaceCadastroIngresso;
import br.edu.ufape.poo.driveincine.negocio.basica.VagaFront;
import br.edu.ufape.poo.driveincine.negocio.cadastro.InterfaceCadastroSessao;
import br.edu.ufape.poo.driveincine.negocio.cadastro.InterfaceCadastroVaga;
import br.edu.ufape.poo.driveincine.negocio.cadastro.excecoes.SessaoJaExistenteException;
import br.edu.ufape.poo.driveincine.negocio.cadastro.excecoes.VagaNãoExisteException;
import br.edu.ufape.poo.driveincine.negocio.cadastro.excecoes.VagaOcupadaException;
import br.edu.ufape.poo.driveincine.negocio.cadastro.excecoes.IngressoNaoExisteException;

public class Fachada {

    @Autowired
    private InterfaceCadastroSessao cadastroSessao;

    @Autowired
    private InterfaceCadastroVaga cadastroVaga;
    
    @Autowired
    private InterfaceCadastroIngresso cadastroIngresso;

    public Sessao procurarSessaoPeloId(long id) {
        return cadastroSessao.procurarSessaoPeloId(id);
    }

    public List<Sessao> listarTodasSessoes() {
        return cadastroSessao.listarTodasSessoes();
    }

    public void excluirSessao(Sessao sessao) {
        cadastroSessao.excluirSessao(sessao);
    }

    public Sessao salvarSessao(Sessao sessao) throws SessaoJaExistenteException {
        List<Sessao> sessoesExistentes = cadastroSessao.findByHorarioAndDiaExibicao(sessao.getHorario(), sessao.getDiaExibicao());
        if (!sessoesExistentes.isEmpty()) {
            throw new SessaoJaExistenteException(sessao.getHorario(), sessao.getDiaExibicao());
        }
        return cadastroSessao.salvarSessao(sessao);
    }

    public List<Sessao> procurarSessoesPeloHorarioEData(float horario, String diaExibicao) {
        return cadastroSessao.findByHorarioAndDiaExibicao(horario, diaExibicao);
    }

    public Vaga procurarVagaPeloId(long id) {
        return cadastroVaga.localizarVagaPorId(id).orElse(null);
    }

    public Vaga salvarVaga(Vaga vaga) {
        return cadastroVaga.salvarVaga(vaga);
    }

    public void atualizarVaga(Vaga vaga) throws VagaOcupadaException {
        if (vaga.isOcupado()) {
            throw new VagaOcupadaException(vaga.getId());
        }
        cadastroVaga.atualizarVaga(vaga);
    }

    public void removerVaga(Vaga vaga) throws VagaNãoExisteException {
        if (!cadastroVaga.localizarVagaPorId(vaga.getId()).isPresent()) {
            throw new VagaNãoExisteException();
        }
        cadastroVaga.removerVaga(vaga);
    }

    public Optional<Vaga> localizarVagaPorId(long id) {
        return cadastroVaga.localizarVagaPorId(id);
    }
    
	public Ingresso salvarIngresso(Ingresso entity) {
		return cadastroIngresso.salvarIngresso(entity);
	}

	public List<Ingresso> listarIngressos() 
			throws IngressoNaoExisteException {
				List<Ingresso> ing = cadastroIngresso.listarIngressos();
				if (ing.size() == 0) {
					throw new IngressoNaoExisteException();
				}
				return ing;
			}

	public void removerIngresso(Long id) {
		cadastroIngresso.removerIngresso(id);
	}

	public void removerIngresso(Ingresso entity) {
		cadastroIngresso.removerIngresso(entity);
	}
	
	public Optional<Ingresso> localizarIngressoId(long id) {
		return cadastroIngresso.localizarIngressoId(id);
	}
}



