package br.com.triersistemas.cinema.repository.impl;

import br.com.triersistemas.cinema.domain.Cinema;
import br.com.triersistemas.cinema.repository.CinemaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class CinemaRepositoryImpl extends BaseRepositoryImpl<UUID, Cinema> implements CinemaRepository {

}
