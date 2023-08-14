package br.edu.ufape.poo.driveincine.negocio.cadastro;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.edu.ufape.poo.driveincine.negocio.basica.Sessao;
import br.edu.ufape.poo.driveincine.negocio.cadastro.excecoes.SessaoJaExistenteException;

@SpringBootTest
class CadastroSessaoTest {

    @Autowired
    private CadastroSessao cadastroSessao;

    @Test
    void testeSalvarSessaoExistente() {
        Sessao sessao = new Sessao(1, 18.5f, "2023-07-27");
        assertThrows(SessaoJaExistenteException.class, () -> cadastroSessao.salvarSessao(sessao));
    }

    @Test
    void testeSalvarSessaoNaoExistente() {
        Sessao sessao = new Sessao(2, 20.0f, "2023-07-28");
        assertDoesNotThrow(() -> cadastroSessao.salvarSessao(sessao));
    }
}
