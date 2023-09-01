package br.edu.ufape.poo.driveincine.negocio.basica;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.util.List;

@Entity
public class Sessao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private float horario;
	private String diaExibicao;
	
	@ManyToOne
	private Filme filme;
	
	@OneToMany
	private List<Vaga> vagas;
	
    @OneToMany
    private List<Ingresso> ingressos;
    
	public Sessao() {

	}

	public Sessao(long id, float horario, String diaExibicao) {
		this.id = id;
		this.horario = horario;
		this.diaExibicao = diaExibicao;

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public float getHorario() {
		return horario;
	}

	public void setHorario(float horario) {
		this.horario = horario;
	}

	public String getDiaExibicao() {
		return diaExibicao;
	}
	public Filme getFilme() {
		return filme;
	}

	public void setFilme(Filme filme) {
		this.filme = filme;
	}

	public List<Vaga> getVagas() {
		return vagas;
	}

	public void setVagas(List<Vaga> vagas) {
		this.vagas = vagas;
	}
	public void setDiaExibicao(String diaExibicao) {
		this.diaExibicao = diaExibicao;
	}
}


