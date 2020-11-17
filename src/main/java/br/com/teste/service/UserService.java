package br.com.teste.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.teste.Utils.IUtilGeral;
import br.com.teste.entity.UserEntity;
import br.com.teste.model.ResponseModel;
import br.com.teste.repository.UserRepository;

@Service
public class UserService implements UserRepository {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder bCryptPasswordEncoder;

	@Override
	public <S extends UserEntity> List<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserEntity> findAll() {

		return userRepository.findAll();
	}

	@Override
	public List<UserEntity> findAll(Sort sort) {
		return null;
	}

	@Override
	public <S extends UserEntity> S insert(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends UserEntity> List<S> insert(Iterable<S> entities) {

		return null;
	}

	@Override
	public <S extends UserEntity> List<S> findAll(Example<S> example) {
		return null;
	}

	@Override
	public <S extends UserEntity> List<S> findAll(Example<S> example, Sort sort) {
		return null;
	}

	@Override
	public Page<UserEntity> findAll(Pageable pageable) {
		return null;
	}

	@Override
	public <S extends UserEntity> S save(S entity) {
		return null;
	}

	@Override
	public Optional<UserEntity> findById(String id) {
		return userRepository.findById(id);
	}

	@Override
	public boolean existsById(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<UserEntity> findAllById(Iterable<String> ids) {
		return null;
	}

	@Override
	public long count() {
		return 0;
	}

	@Override
	public void deleteById(String id) {

	}

	@Override
	public void delete(UserEntity entity) {

	}

	@Override
	public void deleteAll(Iterable<? extends UserEntity> entities) {

	}

	@Override
	public void deleteAll() {

	}

	@Override
	public <S extends UserEntity> Optional<S> findOne(Example<S> example) {

		return null;
	}

	@Override
	public <S extends UserEntity> Page<S> findAll(Example<S> example, Pageable pageable) {

		return null;
	}

	@Override
	public <S extends UserEntity> long count(Example<S> example) {

		return 0;
	}

	@Override
	public <S extends UserEntity> boolean exists(Example<S> example) {

		return false;
	}

	public ResponseModel saveUser(UserEntity user) {

		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setEnabled(true);
		UserEntity entity = userRepository.save(user);

		if (entity != null) {
			return ResponseModel.sucesso(entity, IUtilGeral.RECORDED_WITH_SUCCESS);
		} else {
			return ResponseModel.falha(IUtilGeral.ERROR_RECORDED);
		}
	}

	public ResponseModel update(UserEntity user) {
		Optional<UserEntity> regEnc = userRepository.findById(user.getId());
		if (regEnc != null) {
			UserEntity entSave = userRepository.save(user);
			if (entSave != null) {
				return ResponseModel.sucesso(entSave, IUtilGeral.RECORDED_WITH_SUCCESS);
			} else {
				return ResponseModel.falha(IUtilGeral.ERROR_RECORDED);
			}
		} else {
			return ResponseModel.falha(IUtilGeral.REGISTRATION_DOES_NOT_EXIST);
		}
	}

	public ResponseModel delete(String id) {
		Optional<UserEntity> regEnc = userRepository.findById(id);
		if (regEnc != null) {
			userRepository.deleteById(id);
			return ResponseModel.sucesso(null, IUtilGeral.SUCCESSFULLY_DELETED_REGISTRATION);
		} else {
			return ResponseModel.falha(IUtilGeral.REGISTRATION_DOES_NOT_EXIST);
		}
	}

	@Override
	public UserEntity findByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

}
