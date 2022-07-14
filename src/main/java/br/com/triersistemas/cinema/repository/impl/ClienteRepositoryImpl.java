package br.com.triersistemas.cinema.repository.impl;

import br.com.triersistemas.cinema.domain.Cliente;
import br.com.triersistemas.cinema.domain.QCliente;
import br.com.triersistemas.cinema.repository.ClienteRepositoryCustom;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Ops;
import com.querydsl.jpa.impl.JPAQuery;
import org.apache.tomcat.jni.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.querydsl.core.types.dsl.Expressions;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class ClienteRepositoryImpl implements ClienteRepositoryCustom{

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Cliente> listarPorNome(String nome) {
        final QCliente cliente = QCliente.cliente;
        BooleanBuilder where = new BooleanBuilder();
        where.and(cliente.nome.containsIgnoreCase(nome));

        return new JPAQuery<Cliente>(em).select(cliente).from(cliente).where(where).fetch();
    }

    public List<Cliente> listarPorAniver(LocalDate aniver) {
        final QCliente cliente = QCliente.cliente;
        BooleanBuilder where = new BooleanBuilder();
        where.and(cliente.aniver(aniver));

        return new JPAQuery<Cliente>(em).select(cliente).from(cliente).where(where).fetch();
    }


    public List<Cliente> listarPorIdade(LocalDate idade) {
        final QCliente cliente = QCliente.cliente;
        BooleanBuilder where = new BooleanBuilder();
        where.and(Expressions.dateOperation(LocalDateTime.class, Ops.DateTimeOps.DIFF_YEARS, LocalDate.now(),cliente.aniver) cliente.aniver.(idade));

        return new JPAQuery<Cliente>(em).select(cliente).from(cliente).where(where).fetch();
    }

    public List<Cliente> listarPorId(UUID id) {
        final QCliente cliente = QCliente.cliente;
        BooleanBuilder where = new BooleanBuilder();
        where.and(cliente._super(id));

        return new JPAQuery<Cliente>(em).select(cliente).from(cliente).where(where).fetch();
    }
}
