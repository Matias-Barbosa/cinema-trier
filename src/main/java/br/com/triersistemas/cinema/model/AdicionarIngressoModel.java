package br.com.triersistemas.cinema.model;

import lombok.Getter;

import java.util.List;
import java.util.UUID;

@Getter
public class AdicionarIngressoModel {
    private List<UUID> idIngresso;
}
