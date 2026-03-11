package io.github.fatec.entity;

public record Pessoa(
        String id,
        String nome,
        String endereco,
        String telefone
) {
}