package br.edu.ufape.poo.driveincine.negocio.basica;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Pessoa {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id; 
	private String rg; 
	private String cpf;
	private String endereco;
	
	private String telefone; 
	private String dataNasc;
	private String nome;
	
	public Pessoa() {}
	
	public Pessoa(long id, String rg, String cpf, String endereco, String telefone, String dataNasc2, String nome) {
		super();
		this.id = id;
		this.rg = rg;
		this.cpf = cpf;
		this.endereco = endereco;
		this.telefone = telefone;
		this.dataNasc = dataNasc2;
		this.nome = nome;
	}
	
}