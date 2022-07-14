package br.com.triersistemas.cinema.service.impl;

import br.com.triersistemas.cinema.domain.Atendente;
import br.com.triersistemas.cinema.domain.Cliente;
import br.com.triersistemas.cinema.domain.Ingresso;
import br.com.triersistemas.cinema.domain.Pedido;
import br.com.triersistemas.cinema.exceptions.NaoExisteException;
import br.com.triersistemas.cinema.model.AdicionarIngressoModel;
import br.com.triersistemas.cinema.model.PagarPedidoModel;
import br.com.triersistemas.cinema.model.PedidoModel;
import br.com.triersistemas.cinema.repository.PedidoRepository;
import br.com.triersistemas.cinema.service.AtendenteService;
import br.com.triersistemas.cinema.service.ClienteService;
import br.com.triersistemas.cinema.service.IngressoService;
import br.com.triersistemas.cinema.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PedidoServiceImpl implements PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private AtendenteService atendenteService;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ClienteServiceImpl clienteServiceImpl;

    @Autowired
    private br.com.triersistemas.cinema.service.IngressoService IngressoService;

    @Override
    public List<Pedido> consultar() {
        return pedidoRepository.consultar();
    }

    @Override
    public Pedido consultar(UUID id) {
        return pedidoRepository.consultar(id).orElseThrow(NaoExisteException::new);
    }

    @Override
    public Pedido cadastrar(PedidoModel model) {
        Atendente atendente = atendenteService.consultar(model.getIdAtendente());
        Cliente cliente = clienteServiceImpl.consultarCliente(model.getIdCliente());
        Pedido pedido = new Pedido(atendente, cliente);
        pedidoRepository.cadastrar(pedido);
        return pedido;
    }

    @Override
    public Pedido adicionarIngresso(UUID id, AdicionarIngressoModel model) {
        Pedido pedido = this.consultar(id);
        List<Ingresso> ingressos = IngressoService.consultar(model.getIdIngresso());
        return pedido.adicionarIngresso(ingressos);
    }

    @Override
    public Pedido pagar(UUID id, PagarPedidoModel model) {
        Pedido pedido = this.consultar(id);
        pedido.pagar(model.getValor());
        return pedido;
    }

    @Override
    public Pedido remover(UUID id) {
        Pedido pedido = this.consultar(id);
        pedidoRepository.remover(pedido);
        return pedido;
    }
}
