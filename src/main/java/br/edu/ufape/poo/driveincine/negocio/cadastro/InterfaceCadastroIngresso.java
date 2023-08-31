package br.edu.ufape.poo.driveincine.negocio.cadastro;

import java.util.List;
import java.util.Optional;

import br.edu.ufape.poo.driveincine.negocio.basica.Ingresso;
import br.edu.ufape.poo.driveincine.negocio.cadastro.excecoes.IngressoNaoExisteException;

public interface InterfaceCadastroIngresso {
	
	Ingresso salvarIngresso(Ingresso entity);

	List<Ingresso> listarIngressos() throws IngressoNaoExisteException;

	void removerIngressoId(Long id) throws IngressoNaoExisteException;

	void removerIngresso(Ingresso entity);

	Optional<Ingresso> procurarIngressoId(long id) throws IngressoNaoExisteException;
}
