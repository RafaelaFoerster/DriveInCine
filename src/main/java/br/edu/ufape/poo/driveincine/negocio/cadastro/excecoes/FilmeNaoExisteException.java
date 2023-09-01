package br.edu.ufape.poo.driveincine.negocio.cadastro.excecoes;

public class FilmeNaoExisteException extends Exception{
	private static final long serialVersionUID = 1L;

	public FilmeNaoExisteException(String titulo){
		super("O filme " + titulo + " não existe na coleção.");
	}
}
