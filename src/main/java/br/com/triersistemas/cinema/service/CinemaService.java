package br.com.triersistemas.cinema.service;

import br.com.triersistemas.cinema.domain.Cinema;
import br.com.triersistemas.cinema.model.CinemaModel;

import java.util.List;
import java.util.UUID;

public interface CinemaService {

    List<Cinema> consultar();

    Cinema consultar(UUID id);

    Cinema cadastrar(CinemaModel model);

    Cinema cadastrarRandom();

    Cinema alterar(UUID id, CinemaModel model);

    Cinema remover(UUID id);
}
