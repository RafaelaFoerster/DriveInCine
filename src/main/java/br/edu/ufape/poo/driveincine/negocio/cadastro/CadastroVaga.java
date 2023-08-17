package br.edu.ufape.poo.driveincine.negocio.cadastro;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufape.poo.driveincine.dados.InterfaceColecaoVaga;
import br.edu.ufape.poo.driveincine.negocio.basica.Vaga;
import br.edu.ufape.poo.driveincine.negocio.cadastro.excecoes.VagaNãoExisteException;
import br.edu.ufape.poo.driveincine.negocio.cadastro.excecoes.VagaOcupadaException;

@Service
public class CadastroVaga {
    @Autowired
    private InterfaceColecaoVaga colecaoVaga;

    public Vaga procurarVagaPeloId(long id) {
        return colecaoVaga.findById(id).orElse(null);
    }

    public Vaga salvarVaga(Vaga vaga) {
        return colecaoVaga.save(vaga);
    }
    
    public List<Vaga> ListarVagas() {
		return colecaoVaga.findAll();
	}
    
	public long QuantidadeDeVagas() {
		return colecaoVaga.count();
	}

	public void RemoverVaga(Vaga entity) throws VagaNãoExisteException {
	    if (!colecaoVaga.existsById(entity.getId())) {
	        throw new VagaNãoExisteException();
	    }
	    colecaoVaga.delete(entity);
	}

	public Vaga atualizarStatusVaga(long id, boolean ocupado)throws VagaOcupadaException {
    	Vaga vaga = colecaoVaga.findById(id).orElse(null);
            if (vaga.isOcupado() && ocupado) {
                throw new VagaOcupadaException(id);
        }
        return null;
    }
}
