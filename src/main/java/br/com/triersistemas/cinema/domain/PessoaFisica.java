package br.com.triersistemas.cinema.domain;

import br.com.triersistemas.cinema.helper.StringUtils;

import java.time.LocalDate;
import java.util.List;

public abstract class PessoaFisica extends Pessoa {
    protected PessoaFisica() {
    }

    protected PessoaFisica(final String nome, final LocalDate aniver) {
        super(nome, aniver);
    }

    public PessoaFisica editar(final String nome, final LocalDate aniver) {
        super.editar(nome, aniver);
        return this;
    }
}
