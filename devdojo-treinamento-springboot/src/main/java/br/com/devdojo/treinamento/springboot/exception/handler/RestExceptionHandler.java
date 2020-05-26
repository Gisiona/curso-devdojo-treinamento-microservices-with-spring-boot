package br.com.devdojo.treinamento.springboot.exception.handler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.devdojo.treinamento.springboot.exception.ResourceNotFounfException;
import br.com.devdojo.treinamento.springboot.exception.ResponseRestException;
import br.com.devdojo.treinamento.springboot.exception.ValidationFieldException;

@Controller
@ControllerAdvice
public class RestExceptionHandler {

	@Autowired
	private MessageSource messageSource;
	
	@ExceptionHandler(ResourceNotFounfException.class)
	public ResponseEntity<?> handlerNotFoundException(ResourceNotFounfException exc){
		ResponseRestException response = 
				new ResponseRestException(HttpStatus.NOT_FOUND.value(), 
										exc.getMensagem(), 
										new Date().getTime(), 
										LocalDateTime.now());
		
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> handlerValidationFieldMethodArgumentNotValidException(MethodArgumentNotValidException exc){
		List<FieldError> fieldErrors = exc.getBindingResult().getFieldErrors();
		
		List<ValidationFieldException> response = new ArrayList<ValidationFieldException>();
				
		fieldErrors.forEach(e -> {	
			String msgErro = messageSource.getMessage(e, LocaleContextHolder.getLocale());
			ValidationFieldException objErro = new ValidationFieldException(HttpStatus.BAD_REQUEST.value() ,e.getField(), msgErro);
			response.add(objErro);
		});
		
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}
}
