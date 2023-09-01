package br.edu.ufape.poo.driveincine.negocio.cadastro;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufape.poo.driveincine.dados.InterfaceColecaoCompra;
import br.edu.ufape.poo.driveincine.negocio.basica.Compra;
import br.edu.ufape.poo.driveincine.negocio.cadastro.excecoes.CompraNaoExisteException;

@Service
public class CadastroCompra implements InterfaceCadastroCompra {
	@Autowired
	private InterfaceColecaoCompra colecaoCompra;
	
	public List<Compra> listarCompras() 
		throws CompraNaoExisteException {
			List<Compra> comp = colecaoCompra.findAll();
			if(comp.size() == 0) {
				throw new CompraNaoExisteException();
			}
			return comp;
	}

	public Compra salvarCompra(Compra entity) {
		return colecaoCompra.save(entity);
	}

	public void removerCompraId(Long id) throws CompraNaoExisteException {
		if(!colecaoCompra.existsById(id)) {
			throw new CompraNaoExisteException();
		}
		colecaoCompra.deleteById(id);
	}

	public void removerCompra(Compra entity) {
		colecaoCompra.delete(entity);
	}
	
	public Compra procurarCompraId(long id) throws CompraNaoExisteException {
		Compra temCompra = colecaoCompra.findById(id).orElse(null);
		if(temCompra != null) {
			throw new CompraNaoExisteException();
		}
		return temCompra;
	}
}