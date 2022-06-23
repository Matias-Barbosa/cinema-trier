package br.com.triersistemas.cinema.repository.impl;

import br.com.triersistemas.cinema.domain.Ingresso;
import br.com.triersistemas.cinema.repository.IngressoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class IngressoRepositoryImpl extends BaseRepositoryImpl<UUID, Ingresso> implements IngressoRepository {
}
