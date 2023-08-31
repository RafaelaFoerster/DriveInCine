package br.edu.ufape.poo.driveincine.negocio.basica;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;

@Entity
public class Sessao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private float horario;
    private String diaExibicao;

    @OneToMany
    private List<Ingresso> ingressos;
    @OneToMany
    private List<Vaga> vagas;
    
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

	public void setDiaExibicao(String diaExibicao) {
		this.diaExibicao = diaExibicao;
	}


	public List<Ingresso> getIngressos() {
		return ingressos;
	}

	public void setIngressos(List<Ingresso> ingressos) {
		this.ingressos = ingressos;
	}

}