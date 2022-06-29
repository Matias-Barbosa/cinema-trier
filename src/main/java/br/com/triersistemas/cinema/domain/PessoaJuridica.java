package br.com.triersistemas.cinema.domain;

import br.com.triersistemas.cinema.helper.StringUtils;

import java.time.LocalDate;
import java.util.List;

public abstract class PessoaJuridica extends Pessoa {

    public PessoaJuridica() {
    }

    protected PessoaJuridica(final String nome, final LocalDate aniver) {
        super(nome, aniver);
    }

    public PessoaJuridica editar(final String nome, final LocalDate aniver) {
        super.editar(nome, aniver);
        return this;
    }
}
