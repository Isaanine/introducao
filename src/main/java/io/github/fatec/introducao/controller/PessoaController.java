package io.github.fatec.introducao.controller;

import io.github.fatec.introducao.dto.PessoaPostRequest;
import io.github.fatec.introducao.dto.PessoaPutRequest;
import io.github.fatec.introducao.dto.PessoaResponse;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    @GetMapping
    public PessoaResponse getPessoa() {
        return new PessoaResponse(UUID.randomUUID().toString(), "Isabelle Andrade");
    }

    // POST: Recebe Nome, Telefone, Endereço. Retorna ID e Nome.
    @PostMapping
    public PessoaResponse criarPessoa(@RequestBody PessoaPostRequest request) {
        String idGerado = UUID.randomUUID().toString();

        return new PessoaResponse(idGerado, request.nome());
    }

    // PUT: Recebe ID, Nome, Telefone, Endereço. Retorna ID e Nome.
    @PutMapping
    public PessoaResponse atualizarPessoa(@RequestBody PessoaPutRequest request) {
        return new PessoaResponse(request.id(), request.nome());
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String deletarPessoa(@PathVariable String id) {
        return "Usuario: " + id + " Deletado";
    }
}