package br.edu.ufape.poo.driveincine.comunicacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ufape.poo.driveincine.negocio.basica.Filme;
import br.edu.ufape.poo.driveincine.negocio.basica.Sessao;
import br.edu.ufape.poo.driveincine.negocio.cadastro.excecoes.SessaoJaExistenteException;
import br.edu.ufape.poo.driveincine.negocio.cadastro.excecoes.SessaoNaoExisteException;
import br.edu.ufape.poo.driveincine.negocio.fachada.Fachada;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class SessaoController {

    @Autowired
    private Fachada fachada;

    @GetMapping("/sessao/{id}")
    public Sessao buscarSessaoPorId(@PathVariable Long id) {
        return fachada.procurarSessaoPeloId(id);
    }

    @GetMapping("/sessao")
    public List<Sessao> listarTodasSessoes() {
        return fachada.listarTodasSessoes();
    }

    @PostMapping("/sessao")
    public Sessao salvarSessao(@RequestBody Sessao sessao) throws SessaoJaExistenteException, SessaoNaoExisteException {
        return fachada.salvarSessao(sessao);
    }

    //@GetMapping("/sessao/filme/{filmeId}")
    //public List<Sessao> buscarSessoesPorFilme(@PathVariable Long filmeId) {
        //Filme filme = fachada.procurarFilmePeloId(filmeId);
        //return fachada.procurarSessoesPelofilme(filme);
    //}

    @GetMapping("/sessao/horario-data/{horario}/{diaExibicao}")
    public List<Sessao> buscarSessoesPorHorarioEData(@PathVariable float horario, @PathVariable String diaExibicao) throws SessaoNaoExisteException {
        return fachada.procurarSessoesPeloHorarioEData(horario, diaExibicao);
    }
}
