package br.edu.ufape.poo.driveincine.negocio.cadastro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufape.poo.driveincine.dados.InterfaceColecaoVaga;
import br.edu.ufape.poo.driveincine.negocio.basica.Vaga;

@Service
public class CadastroVaga {
    @Autowired
    private InterfaceColecaoVaga colecaoVaga;

    public Vaga procurarVagaPeloId(long id) {
        return colecaoVaga.findById(id).orElse(null);
    }
}
