package br.com.triersistemas.cinema.domain;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class Cliente extends PessoaFisica {

    public Cliente(final String nome,
                   final LocalDate aniver) {
        super(nome, aniver);
    }

    public Cliente editar(final String nome, final LocalDate aniver) {
        super.editar(nome, aniver);
        return this;
    }
}
