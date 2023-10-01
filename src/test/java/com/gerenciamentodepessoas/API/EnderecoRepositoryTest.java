package com.gerenciamentodepessoas.API;

import com.gerenciamentodepessoas.API.model.Endereco;
import com.gerenciamentodepessoas.API.repository.EnderecoRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@Transactional
public class EnderecoRepositoryTest {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @BeforeEach
    public void setUp() {
        // Você pode configurar dados de teste aqui, se desejar
    }

    @AfterEach
    public void tearDown() {
        enderecoRepository.deleteAll();
    }

    @Test
    public void testSalvarEndereco() {
        // Crie um objeto de endereço para teste
        Endereco endereco = new Endereco();
        endereco.setLogradouro("Av.Conselheiro Aguiar");
        endereco.setCep("51111-011");
        endereco.setNumero("4010");
        endereco.setCidade("Recife");


        enderecoRepository.save(endereco);


        Endereco enderecoSalvo = enderecoRepository.findById(endereco.getId()).orElse(null);


        assertThat(enderecoSalvo).isNotNull();
        assertThat(enderecoSalvo.getLogradouro()).isEqualTo("Av.Conselheiro Aguiar");
        assertThat(enderecoSalvo.getCep()).isEqualTo("51111-011");
        assertThat(enderecoSalvo.getNumero()).isEqualTo("4010");
        assertThat(enderecoSalvo.getCidade()).isEqualTo("Recife");
    }


}