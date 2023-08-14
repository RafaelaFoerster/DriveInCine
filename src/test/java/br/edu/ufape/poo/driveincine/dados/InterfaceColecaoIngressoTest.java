package br.edu.ufape.poo.driveincine.dados;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.edu.ufape.poo.driveincine.negocio.basica.Ingresso;

@SpringBootApplication
public class InterfaceColecaoIngressoTest {
	
	@Autowired
	private InterfaceColecaoIngresso colecaoIngresso;
	
	@Test
	public void gerarIngresso() {
		Ingresso ingressoTest = new Ingresso("qrcode", "AAA000", 16.00f);
		
		
	}
}
