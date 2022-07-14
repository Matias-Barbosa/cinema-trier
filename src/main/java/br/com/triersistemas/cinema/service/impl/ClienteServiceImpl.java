package br.com.triersistemas.cinema.service.impl;

import br.com.triersistemas.cinema.domain.Atendente;
import br.com.triersistemas.cinema.domain.Cliente;
import br.com.triersistemas.cinema.exceptions.NaoExisteException;
import br.com.triersistemas.cinema.model.AtendenteModel;
import br.com.triersistemas.cinema.model.ClienteModel;
import br.com.triersistemas.cinema.repository.ClienteRepository;
import br.com.triersistemas.cinema.service.ClienteService;
import ch.qos.logback.core.net.server.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public List<ClienteModel> consultar() {
        return clienteRepository.findAll().stream().map(ClienteModel::new).toList();
    }

    @Override
    public ClienteModel consultar(UUID id) {
        return new ClienteModel(this.buscarClientePorId(id));
    }

    protected Cliente consultarCliente(UUID id) {
        return this.buscarClientePorId(id);
    }

    @Override
    public ClienteModel cadastrar(ClienteModel model) {
        Cliente cliente = new Cliente(model);
       return new ClienteModel(clienteRepository.save(cliente));
    }

    @Override
    public ClienteModel remover(UUID id) {
       Cliente cliente = this.buscarClientePorId(id);
        clienteRepository.delete(cliente);
        return new ClienteModel(cliente);
    }

    @Override
    public ClienteModel alterar(ClienteModel model) {
        Cliente cliente = this.buscarClientePorId(model.getId());
        cliente.editar(model.getNome(), model.getAniver());
        return new ClienteModel(this.clienteRepository.save(cliente));
    }

    @Override
    public List<Cliente> findByNomeContainsIgnoreCase(String nome) {
        //return this.repository.findByFirstNameIgnoreCase(nome);
        //return this.repository.buscarPeloPrimeirNomeSql(nome);
        //return this.repository.buscarPeloPrimeirNomeJpql(nome);
        return this.clienteRepository.findByNomeContainsIgnoreCase(nome);
    }

    private Cliente buscarClientePorId(UUID id) {
        return clienteRepository.findById(id).orElseThrow(NaoExisteException::new);
    }


}
