package br.com.triersistemas.cinema.repository.impl;

import br.com.triersistemas.cinema.domain.Atendente;
import br.com.triersistemas.cinema.repository.AtendenteRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class AtendenteRepositoryImpl extends BaseRepositoryImpl<UUID, Atendente> implements AtendenteRepository {

}
