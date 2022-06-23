package br.com.triersistemas.cinema.controller;

import br.com.triersistemas.cinema.domain.Cinema;
import br.com.triersistemas.cinema.model.CinemaModel;
import br.com.triersistemas.cinema.service.CinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/fornecedor")
public class CinemaController {

    @Autowired
    private CinemaService cinemaService;

    @GetMapping("/consultar")
    public List<Cinema> consultar() {
        return cinemaService.consultar();
    }

    @PostMapping("/cadastrar-randon")
    public Cinema cadastrarRandon() {
        return cinemaService.cadastrarRandom();
    }

    @PostMapping("/cadastrar")
    public Cinema cadastrar(@RequestBody CinemaModel model) {
        return cinemaService.cadastrar(model);
    }

    @PutMapping("/alterar/{id}")
    public Cinema alterar(@PathVariable UUID id, @RequestBody CinemaModel model) {
        return cinemaService.alterar(id, model);
    }

    @DeleteMapping("/remover/{id}")
    public Cinema remover(@PathVariable UUID id) {
        return cinemaService.remover(id);
    }
}