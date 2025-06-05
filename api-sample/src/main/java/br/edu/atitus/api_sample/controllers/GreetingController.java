package br.edu.atitus.api_sample.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
//RequestController Instancia os Objetos
@RequestMapping("/greeting")
public class GreetingController {
	
	//Requisições por POST
	@PostMapping
	public ResponseEntity<String> postGreeting(
		@RequestBody String value) throws Exception
		{
		if (value.length()>10)
			throw new Exception("Tamanho do valor dave ser no máximo 10");
		return ResponseEntity.status(HttpStatus.CREATED).body(value);
		};
	//Requisições por GET
	@GetMapping(value={"","/","/{namePath}"})
	public String getGreeting(
			@RequestParam(required = false) String name,
			@PathVariable(required = false) String namePath) 
		{
		if (name == null)
			name = namePath != null ? namePath : "World";
		String returnGreeting = String.format("%s %s!", "Hello", name);
		return returnGreeting;
		}
	
	//Manipulador de Exceções
	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<String> handlerException(Exception ex) {
		String message = ex.getMessage().replaceAll("\r\n","");
		return ResponseEntity.badRequest().body(message);
		
	}
}
