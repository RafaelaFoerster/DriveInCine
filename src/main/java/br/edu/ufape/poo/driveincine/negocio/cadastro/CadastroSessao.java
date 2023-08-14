package br.edu.ufape.poo.driveincine.negocio.cadastro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufape.poo.driveincine.dados.InterfaceColecaoSessao;
import br.edu.ufape.poo.driveincine.negocio.basica.Sessao;
import br.edu.ufape.poo.driveincine.negocio.cadastro.excecoes.SessaoJaExistenteException;

import java.util.List;

@Service
public class CadastroSessao {
    @Autowired
    private InterfaceColecaoSessao colecaoSessao;

    public Sessao procurarSessaoPeloId(long id) {
        return colecaoSessao.findById(id).orElse(null);
    }

    public List<Sessao> listarTodasSessoes() {
        return colecaoSessao.findAll();
    }

    public void excluirSessao(Sessao sessao) {
        colecaoSessao.delete(sessao);
    }

    public Sessao salvarSessao(Sessao sessao) throws SessaoJaExistenteException {
        if (procurarSessaoPeloId(sessao.getId()) != null) {
            throw new SessaoJaExistenteException(sessao.getId());
        }
        return colecaoSessao.save(sessao);
    }
}