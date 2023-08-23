package br.edu.ufape.poo.driveincine.negocio.cadastro;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import br.edu.ufape.poo.driveincine.negocio.basica.Vaga;

public interface InterfaceCadastroVaga {

    Vaga salvarVaga(Vaga vaga);

    void atualizarVaga(Vaga vaga);


    void removerVaga(Vaga vaga);

    Optional<Vaga> localizarVagaPorId(long id);

}
