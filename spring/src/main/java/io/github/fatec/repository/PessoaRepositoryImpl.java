package io.github.fatec.repository;

import io.github.fatec.entity.Pessoa;
import io.github.fatec.repository.adapter.PessoaRepositoryAdapter;
import io.github.fatec.repository.mongo.PessoaRepositoryWithMongoDB;
import io.github.fatec.repository.orm.PessoaOrmMongo;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class PessoaRepositoryImpl implements PessoaRepository {

    private final PessoaRepositoryWithMongoDB repository;

    public PessoaRepositoryImpl(PessoaRepositoryWithMongoDB repository) {
        this.repository = repository;
    }

    @Override
    public Pessoa salvar(Pessoa pessoa) {
        PessoaOrmMongo orm = PessoaRepositoryAdapter.castEntity(pessoa);
        PessoaOrmMongo ormSave = repository.save(orm);
        return PessoaRepositoryAdapter.castOrm(ormSave);
    }

    @Override
    public Optional<Pessoa> buscar(String id) {
        return repository.findById(id).map(PessoaRepositoryAdapter::castOrm);
    }

    @Override
    public void deletar(String id) {
        repository.deleteById(id);
    }
}