package br.com.triersistemas.cinema.service;

import br.com.triersistemas.cinema.domain.Atendente;
import br.com.triersistemas.cinema.domain.Cliente;
import br.com.triersistemas.cinema.model.AtendenteModel;
import br.com.triersistemas.cinema.model.ClienteModel;

import java.util.List;
import java.util.UUID;

public interface ClienteService {

    List<Cliente> consultar();

    Cliente consultar(UUID id);

    Cliente cadastrar(ClienteModel model);

    Cliente remover(UUID id);

    Cliente alterar(UUID id, ClienteModel model);
}
