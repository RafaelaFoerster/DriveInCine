package br.edu.ufape.poo.driveincine.negocio.basica;

import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class VagaNormal extends Vaga {
	private double valor;
	
	public VagaNormal() {
		this.valor = 20.0;		
	}
	public VagaNormal(long id, String coluna, int linha, boolean ocupado) {
		super(id, coluna, linha, ocupado);
		
	}

    public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
}