package br.edu.ufape.poo.driveincine.negocio.cadastro.excecoes;

public class CompraNaoExisteException extends Exception {
	
	public CompraNaoExisteException() {
		super("Compra inexistente");
	}
}