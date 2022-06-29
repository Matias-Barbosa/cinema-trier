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
    private AtendenteRepository atendenteRepository;

    @Override
    public List<Atendente> consultar() {
        return atendenteRepository.consultar();
    }

    @Override
    public Atendente consultar(UUID id) {
        return atendenteRepository.consultar(id).orElseThrow(NaoExisteException::new);
    }

    @Override
    public Atendente cadastrar(AtendenteModel model) {
        Atendente atendente = new Atendente(model.getNome(), model.getAniver());
        atendenteRepository.cadastrar(atendente);
        return atendente;
    }

    @Override
    public Atendente cadastrarRandom() {
        Atendente atendente = new Atendente();
        atendenteRepository.cadastrar(atendente);
        return atendente;
    }

    @Override
    public Atendente alterar(UUID id, AtendenteModel model) {
        var atendente = this.consultar(id);
        return (Atendente) atendente.editar(model.getNome(), model.getAniver());
    }

    @Override
    public Atendente remover(UUID id) {
        Atendente atendente = this.consultar(id);
        atendenteRepository.remover(atendente);
        return atendente;
    }
}
