package br.edu.ufape.poo.driveincine.negocio.cadastro.excecoes;

public class VagaNãoExisteException extends Exception{
	
	public VagaNãoExisteException() {
		super("Vaga não existente");
	}

}
