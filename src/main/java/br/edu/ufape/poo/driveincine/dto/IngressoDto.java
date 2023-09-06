package br.edu.ufape.poo.driveincine.dto;

import java.util.List;

public class IngressoDto {
	private String placaDoCarro;
	private int[] vagas;
	private int sessao;
	
	public String getPlacaDoCarro() {
		return placaDoCarro;
	}
	public void setPlacaDoCarro(String placaDoCarro) {
		this.placaDoCarro = placaDoCarro;
	}
	public int[] getVagas() {
		return vagas;
	}
	public void setVagas(int[] vagas) {
		this.vagas = vagas;
	}
	public int getSessao() {
		return sessao;
	}
	public void setSessao(int sessao) {
		this.sessao = sessao;
	}
}