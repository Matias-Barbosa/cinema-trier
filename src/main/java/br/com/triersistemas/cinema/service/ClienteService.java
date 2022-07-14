package br.com.triersistemas.cinema.service;

import br.com.triersistemas.cinema.domain.Atendente;
import br.com.triersistemas.cinema.domain.Cliente;
import br.com.triersistemas.cinema.model.AtendenteModel;
import br.com.triersistemas.cinema.model.ClienteModel;

import java.util.List;
import java.util.UUID;

public interface ClienteService {

    List<ClienteModel> consultar();

    ClienteModel consultar(UUID id);

    ClienteModel cadastrar(ClienteModel model);

    ClienteModel remover(UUID id);

    ClienteModel alterar(ClienteModel model);

    List<Cliente> findByNomeContainsIgnoreCase(String nome);

    List<Cliente> findByIdContainsIgnoreCase(String nome);

    //List<Cliente> findByNomeContainsIgnoreCase(String nome);
}
