package br.edu.ufape.poo.driveincine.negocio.cadastro.excecoes;

public class VagaOcupadaException extends Exception {
	
    public VagaOcupadaException(Long id) {
        super("Vaga selecionada esta ocupada");
    }
}
