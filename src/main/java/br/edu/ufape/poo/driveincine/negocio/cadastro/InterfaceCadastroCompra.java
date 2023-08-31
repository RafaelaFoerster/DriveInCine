package br.edu.ufape.poo.driveincine.negocio.cadastro;

import java.util.List;
import java.util.Optional;

import br.edu.ufape.poo.driveincine.negocio.basica.Compra;

public interface InterfaceCadastroCompra {
	
	Compra salvarCompra(Compra entity);

	List<Compra> listarCompras();

	void removerCompra(Long id);

	void removerCompra(Compra entity);

	Optional<Compra> procurarCompraId(long id);
}
