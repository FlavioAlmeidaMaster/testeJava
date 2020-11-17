package br.com.teste.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.teste.entity.UserEntity;

public interface UserRepository extends MongoRepository<UserEntity, String> {
	UserEntity findByUsername(String username);
}
