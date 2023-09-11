package br.edu.ufape.poo.driveincine.negocio.basica;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Funcionario extends Pessoa {
	    private String login;
	    private String senha;
	    
	    public Funcionario() {}
	    

	    public String getLogin() {
	        return login;
	    }

	    public void setLogin(String login) {
	        this.login = login;
	    }

	    public String getSenha() {
	        return senha;
	    }

	    public void setSenha(String senha) {
	        this.senha = senha;
	    }
}