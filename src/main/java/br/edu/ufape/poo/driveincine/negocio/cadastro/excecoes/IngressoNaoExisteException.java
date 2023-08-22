package br.edu.ufape.poo.driveincine.negocio.cadastro.excecoes;

public class IngressoNaoExisteException extends Exception {
	
	public IngressoNaoExisteException() {
		super("Não existem ingressos a serem listados");
	}
}
