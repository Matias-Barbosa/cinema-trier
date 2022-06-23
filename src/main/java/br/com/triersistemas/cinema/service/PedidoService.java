package br.com.triersistemas.cinema.service;

import br.com.triersistemas.cinema.domain.Pedido;
import br.com.triersistemas.cinema.model.AdicionarIngressoModel;
import br.com.triersistemas.cinema.model.PagarPedidoModel;
import br.com.triersistemas.cinema.model.PedidoModel;
import java.util.List;
import java.util.UUID;

public interface PedidoService {
    List<Pedido> consultar();

    Pedido consultar(UUID id);

    Pedido cadastrar(PedidoModel model);

    Pedido adicionarIngresso(UUID id, AdicionarIngressoModel model);

    Pedido pagar(UUID id, PagarPedidoModel model);
}
