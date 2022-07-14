package br.com.triersistemas.cinema.repository;

import br.com.triersistemas.cinema.domain.Cliente;

import java.util.List;

public interface ClienteRepositoryCustom {
    List<Cliente> listarPorNome(String nome);
}

