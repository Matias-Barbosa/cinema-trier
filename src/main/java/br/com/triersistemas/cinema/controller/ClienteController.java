package br.com.triersistemas.cinema.controller;

import br.com.triersistemas.cinema.domain.Atendente;
import br.com.triersistemas.cinema.domain.Cliente;
import br.com.triersistemas.cinema.model.AtendenteModel;
import br.com.triersistemas.cinema.model.ClienteModel;
import br.com.triersistemas.cinema.service.ClienteService;
import br.com.triersistemas.cinema.service.impl.ClienteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/consultar")
    public List<ClienteModel> consultar() {
        return clienteService.consultar();
    }

    @PostMapping("/cadastrar")
    public ClienteModel cadastrar(@RequestBody ClienteModel model) {
        return clienteService.cadastrar(model);
    }

    @DeleteMapping("/remover/{id}")
    public ClienteModel remover(@PathVariable UUID id) {
        return clienteService.remover(id);
    }

    @PutMapping("/alterar")
    public ClienteModel alterar(@RequestBody ClienteModel model) {
        return clienteService.alterar(model);
    }

    @GetMapping("/listar-por-nome/{nome}")
    public List<Cliente> listarPorNome(@PathVariable String nome) {
        return clienteService.findByNomeContainsIgnoreCase(nome);
    }

    @GetMapping("/listar-por-aniver/{nome}")
    public List<Cliente> listarPorNome(@PathVariable String nome) {
        return clienteService.findByNomeContainsIgnoreCase(nome);
    }

}