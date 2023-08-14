package br.edu.ufape.poo.driveincine.negocio.cadastro;

import java.util.List;
import java.util.Optional;

import br.edu.ufape.poo.driveincine.negocio.basica.Filme;

public interface InterfaceCadastroFilme {

    List<Filme> procurarFilmePeloTitulo(String titulo);

    Filme salvarFilme(Filme filme);

    List<Filme> listarFilmes();

    void removerFilmePorId(Long id);

    void removerFilme(Filme filme);

    Optional<Filme> localizarFilmePorId(long id);

}
