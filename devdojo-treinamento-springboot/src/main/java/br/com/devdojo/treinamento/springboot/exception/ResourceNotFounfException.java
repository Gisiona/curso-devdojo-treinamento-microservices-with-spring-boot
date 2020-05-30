package br.com.devdojo.treinamento.springboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ResourceNotFounfException extends DefaultDetalsException {

	public ResourceNotFounfException(String mensagem) {
		super(mensagem);
	}
}
