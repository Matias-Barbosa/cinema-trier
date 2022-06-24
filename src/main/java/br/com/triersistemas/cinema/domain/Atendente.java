package br.com.triersistemas.cinema.domain;

import br.com.triersistemas.cinema.helper.StringUtils;

import java.time.LocalDate;

public class Atendente extends PessoaFisica {

    private String promocaoDia;

    public Atendente() {
        this.promocaoDia = StringUtils.getRandomMovie();
    }

    public Atendente(final String nome, final LocalDate aniver) {
        super(nome, aniver);
        this.promocaoDia = StringUtils.getRandomMovie();
    }

    public String getPromocaoDia() {
        return promocaoDia;
    }
}
