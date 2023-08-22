package br.edu.ufape.poo.driveincine.negocio.cadastro;

import java.util.List;
import java.util.Optional;

import br.edu.ufape.poo.driveincine.negocio.basica.Ingresso;
import br.edu.ufape.poo.driveincine.negocio.cadastro.excecoes.IngressoNaoExisteException;

public interface InterfaceCadastroIngresso {
	Ingresso salvarIngresso(Ingresso entity);

	List<Ingresso> listarIngressos() throws IngressoNaoExisteException;

	void removerIngresso(Long id);

	void removerIngresso(Ingresso entity);

	Optional<Ingresso> localizarIngressoId(long id);
}
