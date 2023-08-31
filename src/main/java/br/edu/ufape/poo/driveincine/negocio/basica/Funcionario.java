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
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
	  	private String cargo;
	    private String horarioTrabalho;
	    private double salario;
	    private boolean ativo;
	    private String login;
	    private String senha;

	    public Funcionario(String nome, String rg, String cpf, String endereco, String telefone, String dataNasc,
	    String cargo, String horarioTrabalho, double salario, String login, String senha, long id) {
	        super(id, rg, cpf, endereco, telefone, dataNasc, nome);
	        this.cargo = cargo;
	        this.horarioTrabalho = horarioTrabalho;
	        this.salario = salario;
	        this.ativo = true; 
	        this.login = login;
	        this.senha = senha;
	    }

	    //Get e Set
	    public String getCargo() {
	        return cargo;
	    }

	    public void setCargo(String cargo) {
	        this.cargo = cargo;
	    }

	    public String getHorarioTrabalho() {
	        return horarioTrabalho;
	    }

	    public void setHorarioTrabalho(String horarioTrabalho) {
	        this.horarioTrabalho = horarioTrabalho;
	    }

	    public double getSalario() {
	        return salario;
	    }

	    public void setSalario(double salario) {
	        this.salario = salario;
	    }

	    public boolean isAtivo() {
	        return ativo;
	    }

	    public void setAtivo(boolean ativo) {
	        this.ativo = ativo;
	    }

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