package br.com.triersistemas.cinema.controller;

import br.com.triersistemas.cinema.domain.Ingresso;
import br.com.triersistemas.cinema.model.IngressoModel;
import br.com.triersistemas.cinema.service.IngressoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/ingresso")
public class IngressoController {

    @Autowired
    private IngressoService ingressoService;

    @GetMapping("/consultar")
    public List<Ingresso> consultar() {
        return ingressoService.consultar();
    }

    @PostMapping("/cadastrar")
    public Ingresso cadastrar(@RequestBody IngressoModel model) {
        return ingressoService.cadastrar(model);
    }

    @PutMapping("/alterar/{id}")
    public Ingresso alterar(@PathVariable UUID id, @RequestBody IngressoModel model) {
        return ingressoService.alterar(id, model);
    }

    @DeleteMapping("/remover/{id}")
    public Ingresso remover(@PathVariable UUID id) {
        return ingressoService.remover(id);
    }
}