package br.edu.ufape.poo.driveincine.negocio.cadastro;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.edu.ufape.poo.driveincine.negocio.basica.Sessao;
import br.edu.ufape.poo.driveincine.negocio.basica.Vaga;
import br.edu.ufape.poo.driveincine.negocio.basica.VagaNormal;
import br.edu.ufape.poo.driveincine.negocio.cadastro.excecoes.SessaoJaExistenteException;
import br.edu.ufape.poo.driveincine.negocio.cadastro.excecoes.SessaoNaoExisteException;

@SpringBootTest
class CadastroVagaTest {

    @Autowired
    private CadastroVaga cadastroVaga;

    @Autowired
    private CadastroSessao cadastroSessao;

    @Test
    void testSalvarVagaComSessaoExistente() throws SessaoJaExistenteException, SessaoNaoExisteException {
        Sessao sessao = new Sessao();
        sessao.setHorario(15.5f);
        sessao.setDiaExibicao("2023-08-28");

        Sessao sessaoSalva = cadastroSessao.salvarSessao(sessao);

        VagaNormal vaga = new VagaNormal();
        vaga.setColuna("A");
        vaga.setLinha(1);
        vaga.setOcupado(false);

        Vaga vagaSalva = cadastroVaga.salvarVaga(vaga, sessaoSalva.getId());

        assertNotNull(vagaSalva.getId());
        assertEquals(vaga.getColuna(), vagaSalva.getColuna());
        assertEquals(vaga.getLinha(), vagaSalva.getLinha());
        assertEquals(vaga.isOcupado(), vagaSalva.isOcupado());
        assertNotNull(vagaSalva.getSessao());
        assertEquals(sessaoSalva.getId(), vagaSalva.getSessao().getId());
    }
}