package br.com.triersistemas.cinema.controller;

import br.com.triersistemas.cinema.domain.Atendente;
import br.com.triersistemas.cinema.model.AtendenteModel;
import br.com.triersistemas.cinema.service.AtendenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/farmaceutico")
public class AtendenteController {

    @Autowired
    private AtendenteService farmaceuticoService;

    @GetMapping("/consultar")
    public List<Atendente> consultar() {
        return farmaceuticoService.consultar();
    }

    @PostMapping("/cadastrar-random")
    public Atendente cadastrarRandom() {
        return farmaceuticoService.cadastrarRandom();
    }

    @PostMapping("/cadastrar")
    public Atendente cadastrar(@RequestBody AtendenteModel model) {
        return farmaceuticoService.cadastrar(model);
    }

    @PutMapping("/alterar/{id}")
    public Atendente alterar(@PathVariable UUID id, @RequestBody AtendenteModel model) {
        return farmaceuticoService.alterar(id, model);
    }

    @DeleteMapping("/remover/{id}")
    public Atendente remover(@PathVariable UUID id) {
        return farmaceuticoService.remover(id);
    }
}