package br.edu.ufape.poo.driveincine.negocio.cadastro;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufape.poo.driveincine.dados.InterfaceColecaoFilme;
import br.edu.ufape.poo.driveincine.negocio.basica.Filme;
import br.edu.ufape.poo.driveincine.negocio.cadastro.excecoes.FilmeJaExisteException;
import br.edu.ufape.poo.driveincine.negocio.cadastro.excecoes.FilmeNaoExisteException;

@Service
public class CadastroFilme implements InterfaceCadastroFilme{
    @Autowired
    private InterfaceColecaoFilme colecaoFilme;
    

    public List<Filme> listarFilmes() {
        return colecaoFilme.findAll();
    }

    public Filme procurarFilmePeloTitulo(String titulo) {
        return colecaoFilme.findByTitulo(titulo);
    }

    public Filme salvarFilme(Filme entity) throws FilmeJaExisteException {
    	Filme f = procurarFilmePeloTitulo(entity.getTitulo());
    	if (f == null) {
    		return colecaoFilme.save(entity);
        }
        throw new FilmeJaExisteException(entity.getTitulo());
    }

    public void excluirFilme(String titulo) throws FilmeNaoExisteException {
        Filme filme = procurarFilmePeloTitulo(titulo);
        
        if (filme == null) {
            throw new FilmeNaoExisteException(titulo);
        }
        
        colecaoFilme.delete(filme);
    }
}
