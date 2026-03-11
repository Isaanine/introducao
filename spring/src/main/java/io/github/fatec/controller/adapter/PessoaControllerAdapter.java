package io.github.fatec.controller.adapter;

import io.github.fatec.controller.dto.request.PessoaPostRequest;
import io.github.fatec.controller.dto.request.PessoaPutRequest;
import io.github.fatec.controller.dto.response.PessoaResponse;
import io.github.fatec.entity.Pessoa;
import java.util.UUID;

public class PessoaControllerAdapter {
    private PessoaControllerAdapter() {
    }

    public static Pessoa castPostRequest(PessoaPostRequest request) {
        return new Pessoa(UUID.randomUUID().toString(), request.nome(), request.endereco(), request.telefone());
    }

    public static Pessoa castPutRequest(PessoaPutRequest request) {
        return new Pessoa(request.id(), request.nome(), request.endereco(), request.telefone());
    }

    public static PessoaResponse castResponse(Pessoa pessoa) {
        return new PessoaResponse(pessoa.id(), pessoa.nome());
    }
}