package br.com.triersistemas.cinema.repository.impl;

import br.com.triersistemas.cinema.domain.Pedido;
import br.com.triersistemas.cinema.repository.PedidoRepository;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.util.UUID;

@Repository
public class PedidoRepositoryImpl extends BaseRepositoryImpl<UUID, Pedido> implements PedidoRepository {}
