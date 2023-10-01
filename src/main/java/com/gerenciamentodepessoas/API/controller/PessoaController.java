package com.gerenciamentodepessoas.API.controller;

import com.gerenciamentodepessoas.API.model.Endereco;
import com.gerenciamentodepessoas.API.model.Pessoa;
import com.gerenciamentodepessoas.API.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {
    @Autowired
    private PessoaService pessoaService;

    @PostMapping
    public Pessoa criarPessoa(@RequestBody Pessoa pessoa) {
        return pessoaService.criarPessoa(pessoa);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pessoa> consultarPessoa(@PathVariable Long id) {
        Pessoa pessoa = pessoaService.consultarPessoa(id);
        return ResponseEntity.ok(pessoa);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Pessoa> editarPessoa(@PathVariable Long id, @RequestBody Pessoa novaPessoa) {
        Pessoa pessoa = pessoaService.editarPessoa(id, novaPessoa);
        return ResponseEntity.ok(pessoa);
    }

    @GetMapping
    public List<Pessoa> listarPessoas() {
        return pessoaService.listarPessoas();
    }

    @PostMapping("/{id}/endereco")
    public Endereco criarEnderecoParaPessoa(@PathVariable Long id, @RequestBody Endereco endereco) {
        return pessoaService.criarEnderecoParaPessoa(id, endereco);
    }

    @GetMapping("/{id}/enderecos")
    public List<Endereco> listarEnderecosDaPessoa(@PathVariable Long id) {
        return pessoaService.listarEnderecosDaPessoa(id);
    }

    @PutMapping("/{id}/endereco-principal/{enderecoId}")
    public ResponseEntity<Void> definirEnderecoPrincipal(
            @PathVariable Long id,
            @PathVariable Long enderecoId
    ) {
        pessoaService.definirEnderecoPrincipal(id, enderecoId);
        return ResponseEntity.ok().build();
    }

}