package br.edu.ufape.poo.driveincine.negocio.cadastro;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufape.poo.driveincine.dados.InterfaceColecaoFilme;
import br.edu.ufape.poo.driveincine.negocio.basica.Filme;

@Service
public class CadastroFilme {
	@Autowired
	private InterfaceColecaoFilme colecaoFilme;

	public List<Filme> Listafilmes() {
		return colecaoFilme.findAll();
	}

	public Optional<Filme> ProcurarFilmePeloId(Long id) {
		return colecaoFilme.findById(id);
	}

	public Filme save(Filme entity) {
		return colecaoFilme.save(entity);
	}

	public void ExcluirFilme(Filme entity) {
		colecaoFilme.delete(entity);
	}



    
}
