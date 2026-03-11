package io.github.fatec.controller;

import io.github.fatec.controller.adapter.PessoaControllerAdapter;
import io.github.fatec.controller.dto.request.PessoaPostRequest;
import io.github.fatec.controller.dto.request.PessoaPutRequest;
import io.github.fatec.controller.dto.response.PessoaResponse;
import io.github.fatec.entity.Pessoa;
import io.github.fatec.repository.PessoaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    private final PessoaRepository pessoaRepository;

    public PessoaController(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    @GetMapping("/{id}")
    public PessoaResponse buscarPessoa(@PathVariable String id) {
        Optional<Pessoa> pessoa = pessoaRepository.buscar(id);
        return pessoa.map(PessoaControllerAdapter::castResponse).orElse(null);
    }

    @PostMapping
    public PessoaResponse criarPessoa(@RequestBody PessoaPostRequest request) {
        Pessoa pessoaParaSalvar = PessoaControllerAdapter.castPostRequest(request);
        Pessoa pessoaSalva = pessoaRepository.salvar(pessoaParaSalvar);
        return PessoaControllerAdapter.castResponse(pessoaSalva);
    }

    @PutMapping
    public PessoaResponse atualizarPessoa(@RequestBody PessoaPutRequest request) {
        Pessoa pessoaParaAtualizar = PessoaControllerAdapter.castPutRequest(request);
        Pessoa pessoaAtualizada = pessoaRepository.salvar(pessoaParaAtualizar);
        return PessoaControllerAdapter.castResponse(pessoaAtualizada);
    }

    @DeleteMapping("/{id}")
    public String deletarPessoa(@PathVariable String id) {
        pessoaRepository.deletar(id);
        return "Usuario: " + id + " Deletado";
    }
}