package br.com.teste.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.teste.entity.RoleEntity;

public interface RoleRepository extends MongoRepository<RoleEntity, String> {
	
	RoleEntity findByRole(String role);

}
