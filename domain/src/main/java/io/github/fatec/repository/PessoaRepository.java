package io.github.fatec.repository;

import io.github.fatec.entity.Pessoa;
import java.util.Optional;

public interface PessoaRepository {
    Pessoa salvar(Pessoa pessoa);
    Optional<Pessoa> buscar(String id);
    void deletar(String id);
}