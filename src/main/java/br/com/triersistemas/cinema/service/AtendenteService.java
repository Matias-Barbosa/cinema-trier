package br.com.triersistemas.cinema.service;

import br.com.triersistemas.cinema.domain.Atendente;
import br.com.triersistemas.cinema.model.AtendenteModel;

import java.util.List;
import java.util.UUID;

public interface AtendenteService {

    List<Atendente> consultar();

    Atendente consultar(UUID id);

    Atendente cadastrar(AtendenteModel model);

    //Atendente cadastrarRandom();

    Atendente alterar(UUID id, AtendenteModel model);

    Atendente remover(UUID id);
}
