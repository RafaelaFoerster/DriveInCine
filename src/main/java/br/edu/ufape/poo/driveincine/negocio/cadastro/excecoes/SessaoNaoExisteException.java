package br.edu.ufape.poo.driveincine.negocio.cadastro.excecoes;

import br.edu.ufape.poo.driveincine.negocio.basica.Sessao;

public class SessaoNaoExisteException extends Exception {

    public SessaoNaoExisteException() {
        super("A sessão informada não existe no sistema");
 
    }

}
