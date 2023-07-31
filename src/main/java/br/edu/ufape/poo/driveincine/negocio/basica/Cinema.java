package br.edu.ufape.poo.driveincine.negocio.basica;

	import jakarta.persistence.Entity;
	import jakarta.persistence.GeneratedValue;
	import jakarta.persistence.GenerationType;
	import jakarta.persistence.Id;
	import jakarta.persistence.OneToMany;
	import java.util.List;

	@Entity
	public class Cinema {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private long id;
	    private String nome;

	    @OneToMany
	    private List<Filme> filmes;

	    public String getNome() {
	        return nome;
	    }

	    public void setNome(String nome) {
	        this.nome = nome;
	    }

	    public List<Filme> getFilmes() {
	        return filmes;
	    }

		    public void setFilmes(List<Filme> filmes) {
		        this.filmes = filmes;
		    }
	}


