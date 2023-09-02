package br.edu.ufape.poo.driveincine.negocio.fachada;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import br.edu.ufape.poo.driveincine.negocio.basica.Filme;
import br.edu.ufape.poo.driveincine.negocio.basica.Compra;
import br.edu.ufape.poo.driveincine.negocio.basica.Ingresso;
import br.edu.ufape.poo.driveincine.negocio.basica.Sessao;
import br.edu.ufape.poo.driveincine.negocio.basica.Vaga;
import br.edu.ufape.poo.driveincine.negocio.basica.VagaFront;
import br.edu.ufape.poo.driveincine.negocio.basica.VagaNormal;
import br.edu.ufape.poo.driveincine.negocio.cadastro.InterfaceCadastroIngresso;
import br.edu.ufape.poo.driveincine.negocio.cadastro.InterfaceCadastroSessao;
import br.edu.ufape.poo.driveincine.negocio.cadastro.InterfaceCadastroVaga;
import br.edu.ufape.poo.driveincine.negocio.cadastro.InterfaceCadastroCompra;
import br.edu.ufape.poo.driveincine.negocio.cadastro.InterfaceCadastroFilme;
import br.edu.ufape.poo.driveincine.negocio.cadastro.excecoes.SessaoJaExistenteException;
import br.edu.ufape.poo.driveincine.negocio.cadastro.excecoes.SessaoNaoExisteException;
import br.edu.ufape.poo.driveincine.negocio.cadastro.excecoes.VagaNãoExisteException;
import br.edu.ufape.poo.driveincine.negocio.cadastro.excecoes.VagaOcupadaException;
import br.edu.ufape.poo.driveincine.negocio.cadastro.excecoes.FilmeJaExisteException;
import br.edu.ufape.poo.driveincine.negocio.cadastro.excecoes.FilmeNaoExisteException;
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
	
	@Autowired InterfaceCadastroFilme cadastroFilme;

    public Sessao procurarSessaoPeloId(long id) {
        return cadastroSessao.procurarSessaoPeloId(id);
    }
    public  List<Sessao> procurarSessoesPeloFilme(Filme filme) {
        return cadastroSessao.procurarSessoesPelofilme(filme);
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

    public Vaga salvarVaga(Vaga vaga) {
        return cadastroVaga.salvarVaga(vaga);
    }

    public void removerVaga(Long id) throws VagaNãoExisteException {
        cadastroVaga.removerVagaPorId(id);
    }

    public Vaga atualizarStatusVaga(long id, boolean ocupado) throws VagaOcupadaException {
        return cadastroVaga.atualizarStatusVaga(id, ocupado);
    }

    public List<Vaga> ListaVagas() {
		return cadastroVaga.ListaVagas();
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
	

    public List<Filme> listarFilmes() {
        return cadastroFilme.listarFilmes();
    }

    public Filme procurarFilmePeloTitulo(String titulo) {
        return cadastroFilme.procurarFilmePeloTitulo(titulo);
    }

    public Filme salvarFilme(Filme entity) throws FilmeJaExisteException {
        return cadastroFilme.salvarFilme(entity);
    }

    public void excluirFilme(String titulo) throws FilmeNaoExisteException {
        cadastroFilme.excluirFilme(titulo);
        
    }
    
    
    
    
    public Sessao criarVagasParaSessao(Sessao sessao) throws SessaoJaExistenteException {
        char[] colunas = {'A', 'B', 'C', 'D', 'E'};
        
        List<Vaga> vagas = new ArrayList<>();

        for (int linha = 1; linha <= 6; linha++) {
            for (char coluna : colunas) {
                Vaga vaga;
                if (coluna == 'A' || coluna == 'B') {
                    vaga = new VagaFront();
                } else {
                    vaga = new VagaNormal();
                }
                vaga.setLinha(linha);
                vaga.setColuna(String.valueOf(coluna));
                cadastroVaga.salvarVaga(vaga);
                vagas.add(vaga);
            }
        }
        
        sessao.setVagas(vagas); 
        return sessao;

    }
    
}
    

	


