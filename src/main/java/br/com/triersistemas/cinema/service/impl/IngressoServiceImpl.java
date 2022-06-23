package br.com.triersistemas.cinema.service.impl;

import br.com.triersistemas.cinema.domain.Ingresso;
import br.com.triersistemas.cinema.exceptions.NaoExisteException;
import br.com.triersistemas.cinema.model.IngressoModel;
import br.com.triersistemas.cinema.repository.IngressoRepository;
import br.com.triersistemas.cinema.service.IngressoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class IngressoServiceImpl implements IngressoService {

    @Autowired
    private IngressoRepository ingressoRepository;

    @Override
    public List<Ingresso> consultar() {
        return ingressoRepository.consultar();
    }

    @Override
    public Ingresso consultar(UUID id) {
        return ingressoRepository.consultar(id).orElseThrow(NaoExisteException::new);
    }

    @Override
    public List<Ingresso> consultar(List<UUID> ids) {
        return ingressoRepository.consultar(ids);
    }

    @Override
    public Ingresso cadastrar(IngressoModel model) {
        Ingresso ingresso = new Ingresso(model.getNome(), model.getValor());
        ingressoRepository.cadastrar(ingresso);
        return ingresso;
    }

    @Override
    public Ingresso alterar(UUID id, IngressoModel model) {
        Ingresso ingresso = this.consultar(id);
        return ingresso.editar(model.getNome(), model.getValor());
    }

    @Override
    public Ingresso remover(UUID id) {
        Ingresso ingresso = this.consultar(id);
        ingressoRepository.remover(ingresso);
        return ingresso;
    }
}
