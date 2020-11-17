package br.com.teste.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.teste.Utils.IUtilGeral;
import br.com.teste.Utils.JwtTokenProvider;
import br.com.teste.entity.UserEntity;
import br.com.teste.model.ResponseModel;
import br.com.teste.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
@CrossOrigin(origins = "*")
@Api(value = IUtilGeral.CADASTRO_USER, description = IUtilGeral.CADASTRO_USER)
@RestController
@RequestMapping(value = "/register")
public class RegisterController {
	
    @Autowired
    AuthenticationManager authenticationManager;
    
    @Autowired
    JwtTokenProvider jwtTokenProvider;
    
	@Autowired
	private UserService userService;

	@ApiOperation(value = IUtilGeral.FIND_USERS)
	@GetMapping(value = "/findAll")
	public List<UserEntity> listAll() {
		return userService.findAll();
	}
	
	@ApiOperation(value = IUtilGeral.FIND_USERS_ID)
	@GetMapping(value = "/findById")
	public Optional<UserEntity> listById(@RequestParam(required = false) String id) {
		return userService.findById(id);
	}
	
	
	@ApiOperation(value = IUtilGeral.SAVE_USER)
	@PostMapping(value = "/insert")
	public ResponseModel insert(@RequestBody UserEntity user){
		return userService.saveUser(user);
	}
	
	@ApiOperation(value = IUtilGeral.UPDATE_USER)
	@PutMapping(value = "/update")
	public ResponseModel update(@RequestBody UserEntity user){
		return userService.update(user);
	}
	
	@ApiOperation(value = IUtilGeral.DELETE_USER)
	@DeleteMapping(value = "/delete")
	public ResponseModel delete(@ApiParam(value = IUtilGeral.ID_USER) String id){
		return userService.delete(id);
	}
	
}
