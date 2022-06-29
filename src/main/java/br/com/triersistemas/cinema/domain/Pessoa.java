package br.com.triersistemas.cinema.domain;

import br.com.triersistemas.cinema.helper.StringUtils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class Pessoa {

    private UUID id;
    private String nome;
    private LocalDate aniver;

    protected Pessoa() {
        this.id = UUID.randomUUID();
        this.aniver = LocalDate.now();
        this.nome = StringUtils.getRandomName();
    }

    protected Pessoa(final String nome, final LocalDate aniver) {
        this();
        this.nome = nome;
        this.aniver = aniver;
    }

    protected Pessoa editar(final String nome, final LocalDate aniver) {
        this.nome = nome;
        this.aniver = aniver;
        return this;
    }

    public UUID getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getAniver() {
        if (Objects.nonNull(this.aniver)) {
            return this.aniver.format(DateTimeFormatter.ISO_LOCAL_DATE);
        }
        return "";
    }

    public Long getIdade() {
        return Objects.nonNull(this.aniver) ? ChronoUnit.YEARS.between(this.aniver, LocalDate.now()) : 0L;
    }
}
