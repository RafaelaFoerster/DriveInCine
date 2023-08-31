package br.edu.ufape.poo.driveincine.negocio.fachada;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufape.poo.driveincine.negocio.basica.Compra;
import br.edu.ufape.poo.driveincine.negocio.basica.Ingresso;
import br.edu.ufape.poo.driveincine.negocio.basica.Sessao;
import br.edu.ufape.poo.driveincine.negocio.basica.Vaga;
import br.edu.ufape.poo.driveincine.negocio.cadastro.InterfaceCadastroIngresso;
import br.edu.ufape.poo.driveincine.negocio.cadastro.InterfaceCadastroSessao;
import br.edu.ufape.poo.driveincine.negocio.cadastro.InterfaceCadastroVaga;
import br.edu.ufape.poo.driveincine.negocio.cadastro.InterfaceCadastroCompra;
import br.edu.ufape.poo.driveincine.negocio.cadastro.excecoes.SessaoJaExistenteException;
import br.edu.ufape.poo.driveincine.negocio.cadastro.excecoes.SessaoNaoExisteException;
import br.edu.ufape.poo.driveincine.negocio.cadastro.excecoes.VagaNãoExisteException;
import br.edu.ufape.poo.driveincine.negocio.cadastro.excecoes.VagaOcupadaException;
import br.edu.ufape.poo.driveincine.negocio.cadastro.excecoes.IngressoNaoExisteException;

@Service
public class Fachada {

    @Autowired
    private InterfaceCadastroSessao cadastroSessao;

    @Autowired
    private InterfaceCadastroVaga cadastroVaga;
    
    @Autowired
    private InterfaceCadastroIngresso cadastroIngresso;
    
	@Autowired
	private InterfaceCadastroCompra cadastroCompra;

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
	
	public Optional<Ingresso> procurarIngressoId(long id) {
		return cadastroIngresso.procurarIngressoId(id);
	}
	
	public List<Compra> listarCompras() {
		return cadastroCompra.listarCompras();
	}

	public Compra salvarCompra(Compra entity) {
		return cadastroCompra.salvarCompra(entity);
	}

	public void removerCompra(Long id) {
		cadastroCompra.removerCompra(id);
	}

	public void removerCompra(Compra entity) {
		cadastroCompra.removerCompra(entity);
	}
	
	public Optional<Compra> procurarCompraId(long id) {
		return cadastroCompra.procurarCompraId(id);
	}
}

