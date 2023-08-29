package br.edu.ufape.poo.driveincine.negocio.basica;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Cliente extends Pessoa {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

		    private String email;
			private String senha; 
		    private String telefone;
		    private String endereco;
		    private String cartaoCredito;
		    private List<String> assentosReservados;

public Cliente(String nome, String rg, String cpf, String endereco, String telefone, String dataNasc,
            String email, String cartaoCredito, String senha) {
		super(nome, rg, cpf, endereco, telefone, dataNasc);
				this.email = email;
				this.setSenha(senha); 
		        this.cartaoCredito = cartaoCredito;
		        this.assentosReservados = new ArrayList<>();
		    }

		    //Get e Set 
		    public String getEmail() {
		        return email;
		    }

		    public void setEmail(String email) {
		        this.email = email;
		    }

		    public String getTelefone() {
		        return telefone;
		    }

		    public void setTelefone(String telefone) {
		        this.telefone = telefone;
		    }

		    public String getEndereco() {
		        return endereco;
		    }

		    public void setEndereco(String endereco) {
		        this.endereco = endereco;
		    }

		    public String getCartaoCredito() {
		        return cartaoCredito;
		    }

		    public void setCartaoCredito(String cartaoCredito) {
		        this.cartaoCredito = cartaoCredito;
		    }

		    public List<String> getAssentosReservados() {
		        return assentosReservados;
		    }

		    public void setAssentosReservados(List<String> assentosReservados) {
		        this.assentosReservados = assentosReservados;
		    }

			public String getSenha() {
				return senha;
			}

			public void setSenha(String senha) {
				this.senha = senha;
			}

		  


}
