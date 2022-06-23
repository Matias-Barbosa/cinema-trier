package br.com.triersistemas.cinema.service.impl;

import br.com.triersistemas.cinema.domain.Cinema;
import br.com.triersistemas.cinema.exceptions.NaoExisteException;
import br.com.triersistemas.cinema.model.CinemaModel;
import br.com.triersistemas.cinema.repository.CinemaRepository;
import br.com.triersistemas.cinema.service.CinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CinemaServiceImpl implements CinemaService {

    @Autowired
    private CinemaRepository cinemaRepository;

    @Override
    public List<Cinema> consultar() {
        return cinemaRepository.consultar();
    }

    @Override
    public Cinema consultar(UUID id) {
        return cinemaRepository.consultar(id).orElseThrow(NaoExisteException::new);
    }

    @Override
    public Cinema cadastrar(CinemaModel model) {
        Cinema fornecedor = new Cinema(model.getNome(), model.getAniver(), model.getCnpj());
        cinemaRepository.cadastrar(fornecedor);
        return fornecedor;
    }

    @Override
    public Cinema cadastrarRandom() {
        Cinema cinema = new Cinema();
        cinemaRepository.cadastrar(cinema);
        return cinema;
    }

    @Override
    public Cinema alterar(UUID id, CinemaModel model) {
        var cinema = this.consultar(id);
        return (Cinema) cinema.editar(model.getNome(), model.getAniver(), model.getCnpj());
    }

    @Override
    public Cinema remover(UUID id) {
        Cinema cinema = this.consultar(id);
        cinemaRepository.remover(cinema);
        return cinema;
    }
}
