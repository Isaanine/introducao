package io.github.fatec.repository.mongo;

import io.github.fatec.repository.orm.PessoaOrmMongo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepositoryWithMongoDB extends MongoRepository<PessoaOrmMongo, String> {
}