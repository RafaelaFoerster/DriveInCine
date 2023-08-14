package br.edu.ufape.poo.driveincine.negocio.basica;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Compra {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private float valorTotal;
	private Date dataEmissao;
	private String status;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public float getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(float valorTotal) {
		this.valorTotal = valorTotal;
	}
	public Date getDataEmissao() {
		return dataEmissao;
	}
	public void setDataEmissao(Date dataEmissao) {
		this.dataEmissao = dataEmissao;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Compra(float valorTotal, Date dataEmissao, String status) {
		super();
		this.valorTotal = valorTotal;
		this.dataEmissao = dataEmissao;
		this.status = status;
	}
}
