package br.com.triersistemas.cinema.controller;

import br.com.triersistemas.cinema.domain.Atendente;
import br.com.triersistemas.cinema.domain.Pedido;
import br.com.triersistemas.cinema.model.AdicionarIngressoModel;
import br.com.triersistemas.cinema.model.PagarPedidoModel;
import br.com.triersistemas.cinema.model.PedidoModel;
import br.com.triersistemas.cinema.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping("/consultar")
    public List<Pedido> consultar() {
        return pedidoService.consultar();
    }

    @PostMapping("/cadastrar")
    public Pedido cadastrar(@RequestBody PedidoModel model) {
        return pedidoService.cadastrar(model);
    }

    @PutMapping("/adicionar-ingressos/{id}")
    public Pedido adicionarIngresso(@PathVariable UUID id, @RequestBody AdicionarIngressoModel model) {
        return pedidoService.adicionarIngresso(id, model);
    }

    @PutMapping("/pagar/{id}")
    public Pedido pagar(@PathVariable UUID id, @RequestBody PagarPedidoModel model) {
        return pedidoService.pagar(id, model);
    }

    @DeleteMapping("/remover/{id}")
    public Pedido remover(@PathVariable UUID id) {
        return pedidoService.remover(id);
    }
}