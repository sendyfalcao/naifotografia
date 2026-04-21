package com.naifotografia.api.repository;

import com.naifotografia.api.model.Ensaio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List; 

/**
 * Interface de acesso a dados utilizando Spring Data JPA.
 * Abstrai a comunicação com o banco de dados MySQL para a entidade Ensaio.
 */
@Repository

/**
 * Estende JpaRepository para herdar operações CRUD padrão (save, findAll, findById, delete, etc.)
 * para a entidade Ensaio, com chave primária do tipo Long.
 */
public interface EnsaioRepository extends JpaRepository<Ensaio, Long> { 

    List<Ensaio> findByCliente(String cliente);
    // Método de consulta por nome do cliente, útil para buscar ensaios específicos.
}