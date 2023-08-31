package br.edu.ufape.poo.driveincine.negocio.fachada;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufape.poo.driveincine.dto.IngressoDto;
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

	public void removerIngresso(Long id) throws IngressoNaoExisteException {
		cadastroIngresso.removerIngresso(id);
	}

	public void removerIngresso(Ingresso entity) {
		cadastroIngresso.removerIngresso(entity);
	}
	
	public Optional<Ingresso> procurarIngressoId(long id) throws IngressoNaoExisteException {
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
	
	public List<Ingresso> comprarIngresso(IngressoDto ing) {
		Sessao sess = cadastroSessao.procurarSessaoPeloId(ing.getSessao());
		List<Vaga> vagas = new ArrayList<Vaga>();
		List<Ingresso> ingressosGerados = new ArrayList<Ingresso>();
		double valorTotal=0;
		
		for (int i=0; i<ing.getVagas().size();i++) {
			Vaga vagaTemp = cadastroVaga.procurarVagaPeloId(i);
			vagas.add(vagaTemp);
			valorTotal+=vagaTemp.getValor();
			vagaTemp.setOcupado(true);
		}
		
		//gerando compra
		Compra compra = new Compra();
		compra.setStatus("Aprovado");
		Date data = new Date();
		compra.setDataEmissao(data);
		compra.setValorTotal(valorTotal);
		
		//gerando Ingresso por vaga
		for (int i=0; i<vagas.size();i++) {
			Ingresso novo = new Ingresso();
			novo.setQrcode("1234");
			novo.setPlacaDoCarro(ing.getPlacaDoCarro());
			novo.setSessao(sess);
			novo.setCompra(compra);
			novo.setVaga(vagas.get(i));
			
			ingressosGerados.add(novo);
			cadastroIngresso.salvarIngresso(novo);
		}
		
		
		return ingressosGerados;
	}
}

