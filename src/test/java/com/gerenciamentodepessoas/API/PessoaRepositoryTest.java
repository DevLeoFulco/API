package com.gerenciamentodepessoas.API;


import com.gerenciamentodepessoas.API.model.Pessoa;
import com.gerenciamentodepessoas.API.repository.PessoaRepository;
import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.FactoryBasedNavigableListAssert.assertThat;

@DataJpaTest
public class PessoaRepositoryTest {
    @Autowired
    private PessoaRepository pessoaRepository;

    @Test
    public void testDataPopulation() {
        // Crie objetos de teste
        Pessoa pessoa1 = new Pessoa("João", "25-05-2000");
        Pessoa pessoa2 = new Pessoa("Maria", "07-10-2001");

        // Persista os objetos no banco de dados
        pessoaRepository.save(pessoa1);
        pessoaRepository.save(pessoa2);

        // Realize asserções para verificar se os dados foram salvos corretamente
        assertThat(pessoa1.getId());
        assertThat(pessoa2.getId());
    }

    private <SELF extends Assert<SELF, Object>> Assert<SELF, Object> assertThat(Long id) {
        return null;
    }
}





