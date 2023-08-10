package br.edu.ufape.poo.driveincine.negocio.basica;

import jakarta.persistence.Entity;

@Entity
public class VagaNormal extends Vaga {

	public VagaNormal(long id, String coluna, int linha, boolean ocupado) {
		super(id, coluna, linha, ocupado);
		
	}

}
