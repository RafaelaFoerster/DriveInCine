package br.edu.ufape.poo.driveincine.negocio.cadastro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufape.poo.driveincine.dados.InterfaceColecaoCinema;

@Service
public class CadastroCinema {
    @Autowired
    private InterfaceColecaoCinema colecaoCinema;
}