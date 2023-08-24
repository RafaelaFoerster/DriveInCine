package br.edu.ufape.poo.driveincine.dados;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.edu.ufape.poo.driveincine.negocio.basica.Compra;

@SpringBootTest
class InterfaceColecaoCompraTest {
	
	@Autowired 
	private InterfaceColecaoCompra colecaoCompra;

	@Test
	void SalvarCompraTest() {
		
		long qtdCompras = colecaoCompra.count();
		Compra compra = new Compra(20, null, "Aprovada");
		
		colecaoCompra.save(compra);
		long qtdComprasAposAprovacao = colecaoCompra.count();
		
		assertEquals(qtdCompras + 1, qtdComprasAposAprovacao);
	}

}
