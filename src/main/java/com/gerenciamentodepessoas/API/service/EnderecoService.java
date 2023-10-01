package com.gerenciamentodepessoas.API.service;

import com.gerenciamentodepessoas.API.exception.EnderecoNotFoundException;
import com.gerenciamentodepessoas.API.model.Endereco;
import com.gerenciamentodepessoas.API.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class EnderecoService {
    @Autowired
    private EnderecoRepository enderecoRepository;

    public Endereco criarEndereco(Endereco endereco) {
        return enderecoRepository.save(endereco);
    }

    public List<Endereco> listarEnderecos() {
        return enderecoRepository.findAll();
    }

    public Endereco consultarEndereco(Long id) {
        try {
            return enderecoRepository.findById(id)
                    .orElseThrow(() -> new EnderecoNotFoundException("Endereço não encontrado com o ID: " + id));
        } catch (EnderecoNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public Endereco editarEndereco(Long id, Endereco novoEndereco) {

        Endereco enderecoExistente = consultarEndereco(id);


        enderecoExistente.setLogradouro(novoEndereco.getLogradouro());
        enderecoExistente.setCep(novoEndereco.getCep());
        enderecoExistente.setNumero(novoEndereco.getNumero());
        enderecoExistente.setCidade(novoEndereco.getCidade());

        return enderecoRepository.save(enderecoExistente);
    }


    public List<Endereco> listarEnderecosDaPessoa(Long pessoaId) {
        return enderecoRepository.findEnderecosByPessoaId(pessoaId);
    }
}