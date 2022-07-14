package br.com.triersistemas.cinema.domain;

import br.com.triersistemas.cinema.model.ClienteModel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;
@NoArgsConstructor
@Entity
@Table(name = "cliente")
@Getter
public class Cliente extends PessoaFisica {

    public Cliente(final String nome,
                   final LocalDate aniver) {
        super(nome, aniver);
    }

    public Cliente(ClienteModel model) {
        super(model.getNome(), model.getAniver());
    }

    public Cliente editar(final String nome, final LocalDate aniver) {
        super.editar(nome, aniver);
        return this;
    }
}
