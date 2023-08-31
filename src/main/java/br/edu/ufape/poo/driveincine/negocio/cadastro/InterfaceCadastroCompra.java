package br.edu.ufape.poo.driveincine.negocio.cadastro;

import java.util.List;
import java.util.Optional;

import br.edu.ufape.poo.driveincine.negocio.basica.Compra;
import br.edu.ufape.poo.driveincine.negocio.cadastro.excecoes.CompraNaoExisteException;

public interface InterfaceCadastroCompra {
	
	Compra salvarCompra(Compra entity);

	List<Compra> listarCompras() throws CompraNaoExisteException;

	void removerCompraId(Long id) throws CompraNaoExisteException;

	void removerCompra(Compra entity);

	Optional<Compra> procurarCompraId(long id) throws CompraNaoExisteException;
}
