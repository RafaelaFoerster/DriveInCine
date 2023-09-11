package br.edu.ufape.poo.driveincine.negocio.cadastro;

import java.util.List;

import br.edu.ufape.poo.driveincine.negocio.basica.Usuario;
import br.edu.ufape.poo.driveincine.negocio.cadastro.excecoes.UsuarioDuplicadoException;
import br.edu.ufape.poo.driveincine.negocio.cadastro.excecoes.UsuarioNaoExisteException;


public interface InterfaceCadastroUsuario {

	Usuario procurarUsuarioEmail(String email) throws UsuarioNaoExisteException;

	Usuario salvarUsuario(Usuario entity) throws UsuarioDuplicadoException;

	List<Usuario> listarUsuarios();

	boolean verificarExistenciaUsuarioId(Long id);

	Usuario localizarUsuarioId(Long id);

	void removerUsuarioEmail(String email) throws UsuarioNaoExisteException;

}