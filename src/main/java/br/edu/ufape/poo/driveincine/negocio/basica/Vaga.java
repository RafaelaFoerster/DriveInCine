package br.edu.ufape.poo.driveincine.negocio.basica;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public abstract class Vaga {
    

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String coluna;
    private int linha;
    private boolean ocupado;


    public Vaga() {
        
    }
	public Vaga(long id, String coluna, int linha, boolean ocupado) {
		super();
		this.id = id;
		this.coluna = coluna;
		this.linha = linha;
		this.ocupado = ocupado;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getColuna() {
		return coluna;
	}
	public void setColuna(String coluna) {
		this.coluna = coluna;
	}
	public int getLinha() {
		return linha;
	}
	public void setLinha(int string) {
		this.linha = string;
	}
	public boolean isOcupado() {
		return ocupado;
	}
	public void setOcupado(boolean ocupado) {
		this.ocupado = ocupado;
	}
	

		
	}
	
    
    
