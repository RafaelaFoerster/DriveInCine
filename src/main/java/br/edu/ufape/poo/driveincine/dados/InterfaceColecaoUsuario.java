package br.edu.ufape.poo.driveincine.dados;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ufape.poo.driveincine.negocio.basica.Usuario;

@Repository
public interface InterfaceColecaoUsuario 
	extends JpaRepository<Usuario, Long>{
	
	
	public Usuario findByEmail(String email);

}
