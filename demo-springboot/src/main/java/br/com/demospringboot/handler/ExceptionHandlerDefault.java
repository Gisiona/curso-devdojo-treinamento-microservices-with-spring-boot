package br.com.demospringboot.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.demospringboot.exception.ExceptionDefault;
import br.com.demospringboot.exception.ResourceNotFoundException;

@ControllerAdvice
public class ExceptionHandlerDefault {

	@SuppressWarnings("static-access")
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException rnfe){
		
		ExceptionDefault.ResourceNotFoundExceptionBuilder exception  = ExceptionDefault.ResourceNotFoundExceptionBuilder
				.newBuilder()
				.timestamp(new Date().getTime())
				.status(HttpStatus.NOT_FOUND.value())
				.mensagem(rnfe.getMessage())
				.detalhe(rnfe.getMessage())
				.exceptionType(rnfe.getClass().getName())
				.newBuilder();
		
		return new ResponseEntity<>(exception, HttpStatus.NOT_FOUND);		
	}
	
}
