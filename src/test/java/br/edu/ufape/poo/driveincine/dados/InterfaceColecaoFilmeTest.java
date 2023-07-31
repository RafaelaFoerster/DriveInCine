package br.edu.ufape.poo.driveincine.dados;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import br.edu.ufape.poo.driveincine.negocio.basica.Filme;

@SpringBootTest
public class InterfaceColecaoFilmeTest {

    @Autowired
    private InterfaceColecaoFilme colecaoFilme;

    @Test
    public void cadastrarFilmeTest() {
    
        long qtdFilmes = colecaoFilme.count();
        Filme filme = new Filme("Barbie", 120, 12, "sinopse do filme", "Greta ", "URL da Capa", "protagonistas", "Comedia/drama");

  
        colecaoFilme.save(filme);
        long qtdFilmesAposCadastro = colecaoFilme.count();


        assertEquals(qtdFilmes + 1, qtdFilmesAposCadastro);
    }
}
