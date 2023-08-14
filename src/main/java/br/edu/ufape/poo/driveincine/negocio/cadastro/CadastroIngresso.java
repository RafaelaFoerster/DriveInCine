package br.edu.ufape.poo.driveincine.negocio.cadastro;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufape.poo.driveincine.dados.InterfaceColecaoIngresso;
import br.edu.ufape.poo.driveincine.negocio.basica.Ingresso;

@Service
public class CadastroIngresso{
	@Autowired
	private InterfaceColecaoIngresso colecaoIngresso;
	
	//Tá dando erro nessa primeira
	/*public List<Ingresso> procurarIngressoNome(String nome) {
		return colecaoIngresso.findByNome(nome);
	}*/
	public Ingresso salvarIngresso(Ingresso entity) {
		return colecaoIngresso.save(entity);
	} 
	public List<Ingresso> listarIngresso() {
		return colecaoIngresso.findAll();
	}
	public void removerIngresso(Long id) {
		colecaoIngresso.deleteById(id);
	}
	public void removerIngresso(Ingresso entity) {
		colecaoIngresso.delete(entity);
	}
	public Optional<Ingresso> localizarIngressoId(long id) {
		return colecaoIngresso.findById(id);
	}
}
