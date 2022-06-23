package br.com.triersistemas.cinema.domain;

import lombok.Getter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
public class Ingresso {

    private UUID id;
    private String nome;
    private BigDecimal valor;

    public Ingresso(final String nome, final BigDecimal valor) {
        this.id = UUID.randomUUID();
        this.nome = nome;
        this.valor = valor;
    }

    public Ingresso editar(final String nome, final BigDecimal valor) {
        this.nome = nome;
        this.valor = valor;
        return this;
    }
}
