package com.gerenciamentodepessoas.API.repository;

import com.gerenciamentodepessoas.API.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
    @Query("SELECT e FROM Endereco e WHERE e.pessoa.id = ?1")
    List<Endereco> findEnderecosByPessoaId(Long pessoaId);
}