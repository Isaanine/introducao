package io.github.fatec.repository.adapter;

import io.github.fatec.entity.Pessoa;
import io.github.fatec.repository.orm.PessoaOrmMongo;

public class PessoaRepositoryAdapter {
    private PessoaRepositoryAdapter() {
    }

    public static Pessoa castOrm(PessoaOrmMongo orm) {
        return new Pessoa(orm.id(), orm.nome(), orm.endereco(), orm.telefone());
    }

    public static PessoaOrmMongo castEntity(Pessoa entity) {
        return new PessoaOrmMongo(entity.id(), entity.nome(), entity.endereco(), entity.telefone());
    }
}