package br.edu.ufape.poo.driveincine.negocio.basica;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public abstract class Pessoa {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id; 
	private String rg; 
	private String cpf;
	private String telefone; 
	private String dataNasc;
	private String nome;
	
	
	
	public Pessoa() {}
	
	public Pessoa(long id, String rg, String cpf, String endereco, String telefone, String dataNasc2, String nome) {
		super();
		this.id = id;
		this.rg = rg;
		this.cpf = cpf;
		this.telefone = telefone;
		this.dataNasc = dataNasc2;
		this.nome = nome;
		
	}
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(String dataNasc) {
		this.dataNasc = dataNasc;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}