package br.edu.atitus.api_sample.entities;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
//Classe Anêmica
@Entity
@Table(name="tb_user")
//Se não definirmos o nome da tabela, ele vai procurar pelo nome da classe
public class UserEntity {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.UUID)
	//O generated ja gera o valor do UUID
	private UUID id;
	@Column(length = 100, nullable = false) //Tamanho max = 100 e não pode nulo
	private String name;
	@Column(length = 100, nullable = false)
	private String email;
	//Quando criar um JSON não é para passar o password, ele ignora no return
	// biblioteca jackson responsavel por converton json em entidade e vice versa
	@Column(length = 30, nullable = false)
//	@JsonIgnore
	private String password;
	
	@Enumerated(EnumType.ORDINAL)
	@Column(nullable = false)
	private UserType type;
	
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public UserType getType() {
		return type;
	}
	public void setType(UserType type) {
		this.type = type;
	}
}
