package br.edu.ufape.poo.driveincine.negocio.cadastro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufape.poo.driveincine.dados.InterfaceColecaoIngresso;
import br.edu.ufape.poo.driveincine.negocio.basica.Ingresso;

@Service
public class CadastroIngresso {
	@Autowired
	private InterfaceColecaoIngresso ingresso;
	
	public Ingresso listaIngresso(long id) {
		Ingresso ing = ingresso.findById(id) .orElse(null);
		return ing;
	}
}
