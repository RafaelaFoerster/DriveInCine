package br.edu.ufape.poo.driveincine.negocio.cadastro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufape.poo.driveincine.dados.InterfaceColecaoCompra;
import br.edu.ufape.poo.driveincine.negocio.basica.Compra;

@Service
public class CadastroCompra {
	@Autowired
	private InterfaceColecaoCompra compra;
	
	public Compra procurarCompraPeloId(long id) {
		Compra produto = compra.findById(id) .orElse(null);
		return produto;
	}
}
