package com.gerenciamentodepessoas.API.service;

import com.gerenciamentodepessoas.API.model.Endereco;
import com.gerenciamentodepessoas.API.model.Pessoa;
import com.gerenciamentodepessoas.API.repository.EnderecoRepository;
import com.gerenciamentodepessoas.API.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;


@Service
public class PessoaService {
    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    public Pessoa criarPessoa(Pessoa pessoa) {
        return pessoa;
    }

    public List<Pessoa> listarPessoas() {
        return null;
    }

    public Pessoa consultarPessoa(Long id) {
        return null;
    }

    public Pessoa editarPessoa(Long id, Pessoa novaPessoa) {
        return novaPessoa;
    }

    public Endereco criarEnderecoParaPessoa(Long id, Endereco endereco) {
        return endereco;
    }

    public List<Endereco> listarEnderecosDaPessoa(Long id) {
        return null;
    }

    public void definirEnderecoPrincipal(Long id, Long enderecoId) {
    }


}