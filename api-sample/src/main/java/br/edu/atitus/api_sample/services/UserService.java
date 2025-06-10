package br.edu.atitus.api_sample.services;

import br.edu.atitus.api_sample.entities.UserEntity;

public class UserService {
public UserEntity save(UserEntity user) throws Exception {//utilizamos isso para jogar as exceções para camada de cima{
	//Objetivo desta camada - Regra de negócio, formatação dos dados e validar o usuário
	if (user == null)
		throw new Exception("Objeto não pode ser nulo");
	if (user.getName() == null || user.getName().isEmpty())
		throw new Exception("Nome inválido");
	user.setName(user.getName().trim());
	
	if (user.getEmail() == null || user.getEmail().isEmpty())
		throw new Exception("Email inválido");
	user.setEmail(user.getEmail().trim().toLowerCase());
	
	if (user.getPassword() == null 
			|| user.getPassword().isEmpty()
			|| user.getPassword().length() < 8)
		throw new Exception("Senha inválida");
	
	if (user.getType() == null)
		throw new Exception("Tipo de usuário inválido");
	
	
	//TODO Validar a força da senha ( maiusculo, minusculo e numerais
	// TODO Validar email (Regex - no minimo texto@texto.texto)
	// TODO invocar metodo save da camada repository
	return user;
	}
}
