package br.com.triersistemas.cinema.domain;

import br.com.triersistemas.cinema.enuns.EnumStatusPedido;
import lombok.Getter;

import java.io.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
public class Pedido {

    private final UUID id;
    private Atendente atendente;
    private Cliente cliente;
    private List<Ingresso> ingresso;
    private BigDecimal valor;
    private BigDecimal valorPago;
    private BigDecimal troco;
    private final LocalDateTime dataEmissao;
    private LocalDateTime dataPagamento;
    private EnumStatusPedido status;

    public Pedido(final Atendente atendente, final Cliente cliente) {
        this.id = UUID.randomUUID();
        this.atendente = atendente;
        this.cliente = cliente;
        this.ingresso = new ArrayList<>();
        this.valor = BigDecimal.ZERO;
        this.valorPago = BigDecimal.ZERO;
        this.troco = BigDecimal.ZERO;
        this.dataEmissao = LocalDateTime.now();
        this.status = EnumStatusPedido.PENDENTE;
    }

    public Pedido adicionarIngresso(final List<Ingresso> ingresso) {
        if (EnumStatusPedido.PENDENTE.equals(this.status)) {
            this.ingresso.addAll(ingresso);
            this.valor = this.ingresso.stream()
                    .map(Ingresso::getValor)
                    .reduce(BigDecimal.ZERO, BigDecimal::add);
        }
        return this;
    }

    public Pedido pagar(final BigDecimal valor) {
        if (EnumStatusPedido.PENDENTE.equals(this.status) && valor.compareTo(this.valor) > 0) {
            this.valorPago = valor;
            this.troco = this.valorPago.subtract(this.valor);
            this.status = EnumStatusPedido.PAGO;
            this.dataPagamento = LocalDateTime.now();
        }
        return this;
    }
}
