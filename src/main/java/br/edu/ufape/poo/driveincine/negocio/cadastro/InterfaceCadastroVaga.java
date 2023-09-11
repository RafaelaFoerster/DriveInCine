package br.edu.ufape.poo.driveincine.negocio.cadastro;

import java.util.List;

import br.edu.ufape.poo.driveincine.negocio.basica.Vaga;
import br.edu.ufape.poo.driveincine.negocio.cadastro.excecoes.SessaoNaoExisteException;
import br.edu.ufape.poo.driveincine.negocio.cadastro.excecoes.VagaNãoExisteException;
import br.edu.ufape.poo.driveincine.negocio.cadastro.excecoes.VagaOcupadaException;

public interface InterfaceCadastroVaga {

    Vaga procurarVagaPeloId(long id);

    Vaga salvarVaga(Vaga entity);

    void removerVagaPorId(Long id) throws VagaNãoExisteException;

    Vaga atualizarStatusVaga(Long id, boolean ocupado) throws VagaOcupadaException;
    
    public List<Vaga> ListaVagas();
    
 
}