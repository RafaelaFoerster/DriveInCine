package br.edu.ufape.poo.driveincine.negocio.cadastro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufape.poo.driveincine.dados.InterfaceColecaoCompra;
import br.edu.ufape.poo.driveincine.negocio.basica.Compra;

@Service
public class CadastroCompra {
	@Autowired
	private InterfaceColecaoCompra colecaoCompra;
	
	public List<Compra> listarCompras() {
		return colecaoCompra.findAll();
	}

	public Compra salvarCompra(Compra entity) {
		return colecaoCompra.save(entity);
	}

	public void removerCompra(Long id) {
		colecaoCompra.deleteById(id);
	}

	public void removerCompra(Compra entity) {
		colecaoCompra.delete(entity);
	}
	
	public Optional<Compra> procurarCompraId(long id) {
		return colecaoCompra.findById(id);
	}
}
