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

    public List<Sessao> procurarSessoesPeloHorarioEData(float horario, String diaExibicao) {
        return colecaoSessao.findByHorarioAndDiaExibicao(horario, diaExibicao);
    }
   
    public Sessao salvarSessao(Sessao sessao) throws SessaoJaExistenteException {
        List<Sessao> sessoesExistentes = procurarSessoesPeloHorarioEData(sessao.getHorario(), sessao.getDiaExibicao());
        if (!sessoesExistentes.isEmpty()) {
            throw new SessaoJaExistenteException(sessao.getHorario(), sessao.getDiaExibicao());
        }
        return colecaoSessao.save(sessao);
    }

}
