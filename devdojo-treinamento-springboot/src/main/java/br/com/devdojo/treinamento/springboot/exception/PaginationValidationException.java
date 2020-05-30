package br.com.devdojo.treinamento.springboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class PaginationValidationException extends DefaultDetalsException {

	public PaginationValidationException(String mensagem) {
		super(mensagem);
	}
}
