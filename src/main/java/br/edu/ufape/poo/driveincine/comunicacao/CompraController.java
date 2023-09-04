package br.edu.ufape.poo.driveincine.comunicacao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ufape.poo.driveincine.negocio.basica.Compra;
import br.edu.ufape.poo.driveincine.negocio.cadastro.excecoes.CompraNaoExisteException;
import br.edu.ufape.poo.driveincine.negocio.fachada.Fachada;

@RestController
@RequestMapping("/api/v1")
public class CompraController {
	@Autowired
	private Fachada fachada;
	
	@GetMapping("/compra/{id}")
	public Compra procurarCompraId(long id) throws CompraNaoExisteException {
		return fachada.procurarCompraId(id);
	}
	
	@GetMapping("/compra")
	public List<Compra> listarCompras() 
		throws CompraNaoExisteException {
			List<Compra> comp = fachada.listarCompras();
			if(comp.size() == 0) {
				throw new CompraNaoExisteException();
			}
			return comp;
		}
	
	@PostMapping("/compra")
	public Compra salvarCompra(Compra entity) {
		return fachada.salvarCompra(entity);
	}

	@DeleteMapping("/compra/{id}")
	public void removerCompraId(Long id) throws CompraNaoExisteException {
		fachada.removerCompraId(id);
	}

	@DeleteMapping("/compra")
	public void removerCompra(Compra entity) {
		fachada.removerCompra(entity);
	}

}
