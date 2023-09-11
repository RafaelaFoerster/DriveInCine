package br.edu.ufape.poo.driveincine.negocio.basica;

import java.util.List;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import br.edu.ufape.poo.driveincine.negocio.basica.Endereco;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Usuario {
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public List<Ingresso> getIngressos() {
		return ingressos;
	}
	public void setIngressos(List<Ingresso> ingressos) {
		this.ingressos = ingressos;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nome;
	private String email;
	private String telefone;
	private String cpf;
	private String senha;
	
	
	@OneToOne
	@Cascade(CascadeType.ALL)
	private Endereco endereco;
	
	@OneToMany
	private List<Ingresso> ingressos;
	
	public Endereco getEndereco() {
		return endereco;
	}
	public Usuario(long id, String nome, String email, String telefone, String cpf, String senha, Endereco endereco,
			List<Ingresso> ingressos) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.cpf = cpf;
		this.senha = senha;
		this.endereco = endereco;
		this.ingressos = ingressos;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
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
	public Usuario() {
	}
	
}


