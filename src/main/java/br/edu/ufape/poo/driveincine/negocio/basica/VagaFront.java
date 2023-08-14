package br.edu.ufape.poo.driveincine.negocio.basica;

import jakarta.persistence.Entity;

@Entity
public class VagaFront extends Vaga {

    public VagaFront(){
    	
    }

    public VagaFront(long id, String coluna, int linha, boolean ocupado) {
        super(id, coluna, linha, ocupado);
    }
}


