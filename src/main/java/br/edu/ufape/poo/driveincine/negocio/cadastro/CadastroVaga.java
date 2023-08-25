package br.edu.ufape.poo.driveincine.negocio.cadastro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufape.poo.driveincine.dados.InterfaceColecaoVaga;
import br.edu.ufape.poo.driveincine.negocio.basica.Sessao;
import br.edu.ufape.poo.driveincine.negocio.basica.Vaga;
import br.edu.ufape.poo.driveincine.negocio.cadastro.excecoes.SessaoNaoExisteException;
import br.edu.ufape.poo.driveincine.negocio.cadastro.excecoes.VagaNãoExisteException;
import br.edu.ufape.poo.driveincine.negocio.cadastro.excecoes.VagaOcupadaException;

@Service
public class CadastroVaga implements InterfaceCadastroVaga {
	
    @Autowired
    private InterfaceColecaoVaga colecaoVaga;
    @Autowired 
    private InterfaceCadastroSessao cadastroSessao;
    
    public Vaga procurarVagaPeloId(long id) {
        return colecaoVaga.findById(id).orElse(null);
    }

    public Vaga salvarVaga(Vaga vaga, long sessaoId) throws SessaoNaoExisteException {
        Sessao sessao = cadastroSessao.procurarSessaoPeloId(sessaoId);
        if (sessao == null) {
            throw new SessaoNaoExisteException();
        }

        vaga.setSessao(sessao);
        return colecaoVaga.save(vaga);
    }

    public void removerVagaPorId(long id) throws VagaNãoExisteException {
        if (!colecaoVaga.existsById(id)) {
            throw new VagaNãoExisteException();
        }
        colecaoVaga.deleteById(id);
    }

	public Vaga atualizarStatusVaga(long id, boolean ocupado)throws VagaOcupadaException {
    	Vaga vaga = colecaoVaga.findById(id).orElse(null);
            if (vaga.isOcupado() && ocupado) {
                throw new VagaOcupadaException(id);
        }
        return null;
    }
}
