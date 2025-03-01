package br.unip.projeto_clinica.model.usuario;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<Usuario, String> {
    Optional<Usuario> findByEmail(String email);
}
