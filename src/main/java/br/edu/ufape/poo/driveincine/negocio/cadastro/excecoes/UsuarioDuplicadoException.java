package br.edu.ufape.poo.driveincine.negocio.cadastro.excecoes;

public class UsuarioDuplicadoException extends Exception{
	private static final long serialVersionUID = 1L;
	private String email;
	
	public UsuarioDuplicadoException(String email) {
		super("Não é possível cadastrar dois usuários com o mesmo email");
		this.email = email;
	}
	
	public String getEmail() {
		return this.email;
	}
}
