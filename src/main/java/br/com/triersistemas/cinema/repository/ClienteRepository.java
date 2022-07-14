package br.com.triersistemas.cinema.repository;

import br.com.triersistemas.cinema.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, UUID>, ClienteRepositoryCustom {
    List<Cliente> findByNomeContainsIgnoreCase(String nome);

    @Query(value = "SELECT * FROM cliente WHERE idade ilike concat('%', ?1, '%')", nativeQuery = true)
    List<Cliente> buscarPelaIdade(int idade);

    @Query(value = "SELECT c FROM Cliente c WHERE lower(c.nome) like lower(concat('%', ?1, '%'))")
    List<Cliente> buscarPeloPrimeirNomeJpql(String nome);
}

