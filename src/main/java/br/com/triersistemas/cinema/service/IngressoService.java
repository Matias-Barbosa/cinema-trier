package br.com.triersistemas.cinema.service;

import br.com.triersistemas.cinema.domain.Ingresso;
import br.com.triersistemas.cinema.model.IngressoModel;

import java.util.List;
import java.util.UUID;

public interface IngressoService {

    List<Ingresso> consultar();

    Ingresso consultar(UUID id);

    List<Ingresso> consultar(List<UUID> ids);

    Ingresso cadastrar(IngressoModel model);

    Ingresso alterar(UUID id, IngressoModel model);

    Ingresso remover(UUID id);
}
