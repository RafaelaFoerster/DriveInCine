package br.edu.ufape.poo.driveincine.negocio.cadastro;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufape.poo.driveincine.dados.InterfaceColecaoIngresso;
import br.edu.ufape.poo.driveincine.negocio.basica.Ingresso;
import br.edu.ufape.poo.driveincine.negocio.cadastro.excecoes.IngressoNaoExisteException;

@Service
public class CadastroIngresso implements InterfaceCadastroIngresso {
	@Autowired
	private InterfaceColecaoIngresso colecaoIngresso;

	public Ingresso salvarIngresso(Ingresso entity) {
		return colecaoIngresso.save(entity);
	}

	public List<Ingresso> listarIngressos() 
		throws IngressoNaoExisteException {
			List<Ingresso> ing = colecaoIngresso.findAll();
			if (ing.size() == 0) {
				throw new IngressoNaoExisteException();
			}
			return ing;
		}

	public void removerIngressoId(Long id) throws IngressoNaoExisteException {
		if (!colecaoIngresso.existsById(id)) {
			throw new IngressoNaoExisteException();
		}
		colecaoIngresso.deleteById(id);
	}

	public void removerIngresso(Ingresso entity) {
		colecaoIngresso.delete(entity);
	}
	
	public Ingresso procurarIngressoId(long id) throws IngressoNaoExisteException {
		Ingresso temIngresso = colecaoIngresso.findById(id).orElse(null);
		if (temIngresso != null) {
			throw new IngressoNaoExisteException();
		}
		return temIngresso;
	}
}
