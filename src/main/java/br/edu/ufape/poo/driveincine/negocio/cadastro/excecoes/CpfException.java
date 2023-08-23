package br.edu.ufape.poo.driveincine.negocio.cadastro.excecoes;

public class CpfException extends Exception {
	
    public CpfException() {
        super("Número de CPF inválido!");
    }
}
