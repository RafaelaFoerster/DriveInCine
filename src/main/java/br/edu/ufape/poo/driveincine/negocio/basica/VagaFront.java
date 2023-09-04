package br.edu.ufape.poo.driveincine.negocio.basica;

import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class VagaFront extends Vaga {
	private double valor;
	
    public VagaFront(){
    	this.valor = 32.0;
    }

	public VagaFront(long id, String coluna, int linha, boolean ocupado) {
        super(id, coluna, linha, ocupado);
    }
	
    public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
}

