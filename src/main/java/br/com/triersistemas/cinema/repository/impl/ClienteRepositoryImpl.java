package br.com.triersistemas.cinema.repository.impl;

import br.com.triersistemas.cinema.domain.Cliente;
import br.com.triersistemas.cinema.repository.ClienteRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class ClienteRepositoryImpl extends BaseRepositoryImpl<UUID, Cliente> implements ClienteRepository {

}
