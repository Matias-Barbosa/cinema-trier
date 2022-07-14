package br.com.triersistemas.cinema.service.impl;

import br.com.triersistemas.cinema.domain.Atendente;
import br.com.triersistemas.cinema.domain.Cliente;
import br.com.triersistemas.cinema.exceptions.NaoExisteException;
import br.com.triersistemas.cinema.model.AtendenteModel;
import br.com.triersistemas.cinema.model.ClienteModel;
import br.com.triersistemas.cinema.repository.ClienteRepository;
import br.com.triersistemas.cinema.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public List<Cliente> consultar() {
        return clienteRepository.consultar();
    }

    @Override
    public Cliente consultar(UUID id) {
        return clienteRepository.consultar(id).orElseThrow(NaoExisteException::new);
    }

    @Override
    public Cliente cadastrar(ClienteModel model) {
        var cliente = new Cliente(model.getNome(), model.getAniver());
        clienteRepository.cadastrar(cliente);
        return cliente;
    }

    @Override
    public Cliente remover(UUID id) {
        Cliente cliente = this.consultar(id);
        clienteRepository.remover(cliente);
        return cliente;
    }

    @Override
    public Cliente alterar(UUID id, ClienteModel model) {
        var cliente = this.consultar(id);
        return (Cliente) cliente.editar(model.getNome(), model.getAniver());
    }
}
