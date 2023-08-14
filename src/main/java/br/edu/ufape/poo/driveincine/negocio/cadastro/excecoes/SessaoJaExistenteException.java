package br.edu.ufape.poo.driveincine.negocio.cadastro.excecoes;

public class SessaoJaExistenteException extends Exception {

    public SessaoJaExistenteException(long id) {
        super("Sessao cadastrada ja existe");
    }
}
