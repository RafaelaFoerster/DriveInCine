package br.edu.ufape.poo.driveincine.negocio.cadastro.excecoes;

public class FilmeJaExisteException extends Exception{
	private static final long serialVersionUID = 1L;

	public FilmeJaExisteException(String titulo){
		super("O filme " + titulo + " já está cadastrado.");
	}
}
