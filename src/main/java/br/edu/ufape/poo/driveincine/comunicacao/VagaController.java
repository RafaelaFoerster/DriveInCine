package br.edu.ufape.poo.driveincine.comunicacao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ufape.poo.driveincine.negocio.basica.Sessao;
import br.edu.ufape.poo.driveincine.negocio.basica.Vaga;
import br.edu.ufape.poo.driveincine.negocio.basica.VagaFront;
import br.edu.ufape.poo.driveincine.negocio.basica.VagaNormal;
import br.edu.ufape.poo.driveincine.negocio.cadastro.excecoes.SessaoNaoExisteException;
import br.edu.ufape.poo.driveincine.negocio.cadastro.excecoes.VagaNãoExisteException;
import br.edu.ufape.poo.driveincine.negocio.cadastro.excecoes.VagaOcupadaException;
import br.edu.ufape.poo.driveincine.negocio.fachada.Fachada;

@RestController
@RequestMapping("/api/v1")
public class VagaController {

    @Autowired
    private Fachada fachada;

    @PostMapping("/vaga/normal")
    public VagaNormal salvarVagaNormal(@RequestBody VagaNormal vaga) {
        return (VagaNormal) fachada.salvarVaga(vaga);
    }
    
    @PostMapping("/vaga/front")
    public VagaFront salvarVagaFront(@RequestBody VagaFront vaga){
        return (VagaFront) fachada.salvarVaga(vaga);
    }
    
    
    @GetMapping("/vaga/{id}")
    public Vaga buscarVagaPorId(@PathVariable Long id) {
        return fachada.procurarVagaPeloId(id);
    }
    
    @GetMapping("/vaga")
    public List<Vaga> ListaVagas() {
        return fachada.ListaVagas();
    }
    
    @GetMapping("/vaga/sessao/{id}")
    public List <Vaga> listarVagasPorSessao(@PathVariable Long id){
   	 return fachada.listarVagasPorSessao(id);
    }
    
    
    @DeleteMapping("/vaga/{id}")
    public void removerVaga(@PathVariable Long id) throws VagaNãoExisteException {
        fachada.removerVaga(id);
    }

    @PatchMapping("/vaga/{id}/{ocupado}")
    public Vaga atualizarStatusVaga(@PathVariable Long id, @PathVariable boolean ocupado) throws VagaOcupadaException {
        return fachada.atualizarStatusVaga(id, ocupado);
    }
 
    
}