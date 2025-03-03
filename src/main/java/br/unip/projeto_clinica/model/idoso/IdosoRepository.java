package br.unip.projeto_clinica.model.idoso;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IdosoRepository extends MongoRepository<Idoso, Long> {}
