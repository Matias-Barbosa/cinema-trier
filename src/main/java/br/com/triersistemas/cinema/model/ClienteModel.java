package br.com.triersistemas.cinema.model;

import br.com.triersistemas.cinema.domain.Cliente;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@NoArgsConstructor
public class ClienteModel {

    private UUID id;
    private String nome;
    private LocalDate aniver;
    private Long idade;

    public ClienteModel (Cliente cliente) {
        this.id = cliente.getId();
        this.nome = cliente.getNome();
        this.aniver = cliente.getAniver();
        this.idade = cliente.getIdade();
    }
}
