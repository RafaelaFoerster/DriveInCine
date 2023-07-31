package br.edu.ufape.poo.driveincine.dados;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import br.edu.ufape.poo.driveincine.negocio.basica.Cinema;
import br.edu.ufape.poo.driveincine.negocio.basica.Filme;

@SpringBootTest
public class InterfaceColecaoCinemaTest {

    @Autowired
    private InterfaceColecaoCinema colecaoCinema;

    @Test
    public void cadastrarCinemaTest() {

        long qtdCinemas = colecaoCinema.count();
        Cinema cinema = new Cinema();

        Filme filmeteste = new Filme("Aliens", 135, 16, "Sinopse do Filme ", "Diretor", "URL da Capa", "Protagonistas", "Gênero suspense");
    
        cinema.getFilmes().add(filmeteste);

        colecaoCinema.save(cinema);
        long qtdCinemasAposCadastro = colecaoCinema.count();
        
        assertEquals(qtdCinemas + 1, qtdCinemasAposCadastro);
    }
}

