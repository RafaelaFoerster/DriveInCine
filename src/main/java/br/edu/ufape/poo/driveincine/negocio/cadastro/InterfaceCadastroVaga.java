package br.edu.ufape.poo.driveincine.negocio.cadastro;

import br.edu.ufape.poo.driveincine.negocio.basica.Vaga;
import br.edu.ufape.poo.driveincine.negocio.cadastro.excecoes.SessaoNaoExisteException;
import br.edu.ufape.poo.driveincine.negocio.cadastro.excecoes.VagaNãoExisteException;
import br.edu.ufape.poo.driveincine.negocio.cadastro.excecoes.VagaOcupadaException;

public interface InterfaceCadastroVaga {

    Vaga procurarVagaPeloId(long id);

    Vaga salvarVaga(Vaga entity);

    void removerVagaPorId(long id) throws VagaNãoExisteException;

    Vaga atualizarStatusVaga(long id, boolean ocupado) throws VagaOcupadaException;

}
