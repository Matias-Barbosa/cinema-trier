package br.com.triersistemas.cinema.controller;

import br.com.triersistemas.cinema.domain.Cliente;
import br.com.triersistemas.cinema.model.ClienteModel;
import br.com.triersistemas.cinema.service.ClienteService;
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
    public List<Cliente> consultar() {
        return clienteService.consultar();
    }

    @PostMapping("/cadastrar")
    public Cliente cadastrar(@RequestBody ClienteModel model) {
        return clienteService.cadastrar(model);
    }

    @DeleteMapping("/remover/{id}")
    public Cliente remover(@PathVariable UUID id) {
        return clienteService.remover(id);
    }
}