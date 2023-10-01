package com.gerenciamentodepessoas.API.controller;

import com.gerenciamentodepessoas.API.model.Endereco;
import com.gerenciamentodepessoas.API.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {
    @Autowired
    private EnderecoService enderecoService;

    @PostMapping
    public Endereco criarEndereco(@RequestBody Endereco endereco) {
        return enderecoService.criarEndereco(endereco);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Endereco> consultarEndereco(@PathVariable Long id) {
        Endereco endereco = enderecoService.consultarEndereco(id);
        return ResponseEntity.ok(endereco);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Endereco> editarEndereco(@PathVariable Long id, @RequestBody Endereco novoEndereco) {
        Endereco endereco = enderecoService.editarEndereco(id, novoEndereco);
        return ResponseEntity.ok(endereco);
    }

    @GetMapping
    public List<Endereco> listarEnderecos() {
        return enderecoService.listarEnderecos();
    }

    @GetMapping("/pessoa/{pessoaId}")
    public List<Endereco> listarEnderecosDaPessoa(@PathVariable Long pessoaId) {
        return enderecoService.listarEnderecosDaPessoa(pessoaId);
    }


}