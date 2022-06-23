package br.com.triersistemas.cinema.domain;

import br.com.triersistemas.cinema.helper.StringUtils;

import java.time.LocalDate;
import java.util.List;

public class Cinema extends PessoaJuridica {

    private List<String> filmes;

    public Cinema() {
        this.filmes = StringUtils.getMovieList();
    }

    public Cinema(final String nome, final LocalDate aniver, final String cnpj) {
        super(nome, aniver, cnpj);
        this.filmes = StringUtils.getMovieList();
    }

    public List<String> getProdutos() {
        return filmes;
    }
}
