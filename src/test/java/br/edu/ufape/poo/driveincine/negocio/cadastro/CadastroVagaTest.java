package br.edu.ufape.poo.driveincine.negocio.cadastro;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.edu.ufape.poo.driveincine.negocio.basica.Vaga;
import br.edu.ufape.poo.driveincine.negocio.basica.VagaFront;
import br.edu.ufape.poo.driveincine.negocio.basica.VagaNormal;
import br.edu.ufape.poo.driveincine.negocio.cadastro.excecoes.VagaOcupadaException;

@SpringBootTest
class CadastroVagaTest {

    @Autowired
    private CadastroVaga cadastroVaga;

    @Test
    void testeAtualizarStatusVagaOcupada() {
        Vaga vaga = new VagaNormal(41, "A", 1, false);
        vaga = cadastroVaga.salvarVaga(vaga);
        final Vaga vagaFinal = vaga;
        assertDoesNotThrow(() -> cadastroVaga.atualizarStatusVaga(vagaFinal.getId(), true));
    }


    @Test
    void testeAtualizarStatusVagaOcupadaDuplicada() {
        Vaga vaga = new VagaFront(2, "B", 2, true);
        vaga = cadastroVaga.salvarVaga(vaga);
        final Vaga vagaFinal = vaga;
        assertThrows(VagaOcupadaException.class, () -> cadastroVaga.atualizarStatusVaga(vagaFinal.getId(), true));
    }

    @Test
    void testeAtualizarStatusVagaLivre() {
        Vaga vaga = new VagaNormal(3, "C", 3, false);
        vaga = cadastroVaga.salvarVaga(vaga);
        final Vaga vagaFinal = vaga;
        assertDoesNotThrow(() -> cadastroVaga.atualizarStatusVaga(vagaFinal.getId(), false));
    }
}
