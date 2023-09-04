package br.edu.ufape.poo.driveincine.negocio.basica;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
public class Ingresso {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String qrcode;
	private String placaDoCarro;
	
	@OneToOne
	@Cascade(CascadeType.ALL)
	private Compra compra;
	@OneToOne
	@Cascade(CascadeType.ALL)
	private Vaga vaga;
	@ManyToOne
	@Cascade(CascadeType.ALL)
    @JoinColumn(name = "sessao_id")
	private Sessao sessao;
	

	public Ingresso() {
		
	}
	
	public Ingresso(String qrcode, String placaDoCarro, float valorDoIngresso) {
		super();
		this.qrcode = qrcode;
		this.placaDoCarro = placaDoCarro;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getQrcode() {
		return qrcode;
	}
	public void setQrcode(String qrcode) {
		this.qrcode = qrcode;
	}
	public String getPlacaDoCarro() {
		return placaDoCarro;
	}
	public void setPlacaDoCarro(String placaDoCarro) {
		this.placaDoCarro = placaDoCarro;
	}
	public Compra getCompra() {
		return compra;
	}

	public void setCompra(Compra compra) {
		this.compra = compra;
	}

	public Vaga getVaga() {
		return vaga;
	}

	public void setVaga(Vaga vaga) {
		this.vaga = vaga;
	}

	public Sessao getSessao() {
		return sessao;
	}

	public void setSessao(Sessao sessao) {
		this.sessao = sessao;
	}
}