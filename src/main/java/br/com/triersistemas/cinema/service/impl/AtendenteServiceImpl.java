package br.com.triersistemas.cinema.service.impl;

import br.com.triersistemas.cinema.domain.Atendente;
import br.com.triersistemas.cinema.exceptions.NaoExisteException;
import br.com.triersistemas.cinema.model.AtendenteModel;
import br.com.triersistemas.cinema.repository.AtendenteRepository;
import br.com.triersistemas.cinema.service.AtendenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AtendenteServiceImpl implements AtendenteService {

    @Autowired
    private AtendenteRepository farmaceuticoRepository;

    @Override
    public List<Atendente> consultar() {
        return farmaceuticoRepository.consultar();
    }

    @Override
    public Atendente consultar(UUID id) {
        return farmaceuticoRepository.consultar(id).orElseThrow(NaoExisteException::new);
    }

    @Override
    public Atendente cadastrar(AtendenteModel model) {
        Atendente farmaceutico = new Atendente(model.getNome(), model.getAniver());
        farmaceuticoRepository.cadastrar(farmaceutico);
        return farmaceutico;
    }

    @Override
    public Atendente cadastrarRandom() {
        Atendente farmaceutico = new Atendente();
        farmaceuticoRepository.cadastrar(farmaceutico);
        return farmaceutico;
    }

    @Override
    public Atendente alterar(UUID id, AtendenteModel model) {
        var farmaceutico = this.consultar(id);
        return (Atendente) farmaceutico.editar(model.getNome(), model.getAniver(), model.getCpf());
    }

    @Override
    public Atendente remover(UUID id) {
        Atendente farmaceutico = this.consultar(id);
        farmaceuticoRepository.remover(farmaceutico);
        return farmaceutico;
    }
}
