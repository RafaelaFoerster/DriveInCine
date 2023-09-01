package br.edu.ufape.poo.driveincine.dto;

import java.util.List;

public class IngressoDto {
	private String placaDoCarro;
	private List<Integer> vagas;
	private int sessao;
	
	public String getPlacaDoCarro() {
		return placaDoCarro;
	}
	public void setPlacaDoCarro(String placaDoCarro) {
		this.placaDoCarro = placaDoCarro;
	}
	public List<Integer> getVagas() {
		return vagas;
	}
	public void setVagas(List<Integer> vagas) {
		this.vagas = vagas;
	}
	public int getSessao() {
		return sessao;
	}
	public void setSessao(int sessao) {
		this.sessao = sessao;
	}
}