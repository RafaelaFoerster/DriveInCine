package br.edu.ufape.poo.driveincine.comunicacao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ufape.poo.driveincine.negocio.basica.Sessao;
import br.edu.ufape.poo.driveincine.negocio.cadastro.excecoes.SessaoJaExistenteException;
import br.edu.ufape.poo.driveincine.negocio.cadastro.excecoes.SessaoNaoExisteException;
import br.edu.ufape.poo.driveincine.negocio.fachada.Fachada;


@RestController
@RequestMapping("/api/v1")
public class SessaoController {
	
	@Autowired
	public Fachada fachada;
	
	@GetMapping("/sessao")
	public List<Sessao> listarSessoes() {
		return fachada.listarTodasSessoes();
	}
	
	@PostMapping("/sessao")
	public Sessao cadastrarSessao(@RequestBody Sessao u) 
			throws SessaoJaExistenteException, SessaoNaoExisteException{
			return fachada.salvarSessao(u);
	}
	
	@PatchMapping("/sessao/{id}")
	public Sessao atualizarSessao(@PathVariable long id, @RequestBody Sessao u) throws SessaoJaExistenteException, SessaoNaoExisteException {
		u.setId(id);
		return fachada.salvarSessao(u);
	}
	
	@DeleteMapping("/sessao/{sessaoId}")
	public String apagarSessao(@PathVariable long sessaoId) throws SessaoNaoExisteException {
	    fachada.excluirSessao(sessaoId);
	    return "ok";
	}
}