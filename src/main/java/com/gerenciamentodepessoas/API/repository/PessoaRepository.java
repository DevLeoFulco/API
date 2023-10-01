package com.gerenciamentodepessoas.API.repository;

import com.gerenciamentodepessoas.API.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
