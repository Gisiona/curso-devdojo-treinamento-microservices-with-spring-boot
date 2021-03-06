package br.com.demospringboot.controller;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.demospringboot.dto.ResponseData;
import br.com.demospringboot.exception.ExceptionDefault;
import br.com.demospringboot.exception.ResourceNotFoundException;
import br.com.demospringboot.model.EstudanteModel;
import br.com.demospringboot.repository.EstudanteRepository;
import br.com.demospringboot.util.DateUtils;
import br.com.demospringboot.validation.EstudanteValidation;

@RestController
@ResponseBody
@RequestMapping("/api/v1/estudantes")
public class EstudanteController {
	
	private EstudanteRepository repository;
	
	@Autowired
	public EstudanteController(EstudanteRepository _repository) {
		this.repository = _repository;
	}
	
	@GetMapping("/teste")
	public ResponseEntity<?> TesteConvertDate()
	{	
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		date = DateUtils.asDate(LocalDate.now());
		
		System.out.println(date);
		System.out.println(dateFormat.format(date)); 
		
		List<EstudanteModel> estudantes = repository.findAll();		
		return new ResponseEntity<>(new ResponseData(dateFormat), HttpStatus.OK);
	}
	
	
	@GetMapping("/listar")
	public ResponseEntity<?> ListarTodos()
	{	
		List<EstudanteModel> estudantes = repository.findAll();		
		return new ResponseEntity<>(new ResponseData(estudantes), HttpStatus.OK);
	}
	
	
	@GetMapping("/listar/{nome}")
	public ResponseEntity<?> ListarPorNome(@PathVariable String nome)
	{	
		List<EstudanteModel> estudantes = repository.findByNomeIgnoreCaseContaining(nome);	
		if(!EstudanteValidation.validaIfEstudanteExiste(estudantes.get(0))) {
			return new ResponseEntity<>(new ResponseData(new ResourceNotFoundException("Estudante não encontrado.")),HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(new ResponseData(estudantes), HttpStatus.OK);
	}
	
	
	@GetMapping("/listar/{id}")
	public ResponseEntity<?> ListarPorId(@PathVariable("id") Long id )
	{	
		EstudanteModel estudante = repository.getOne(id);
		if(!EstudanteValidation.validaIfEstudanteExiste(estudante)) {
			return new ResponseEntity<>(new ResponseData(new ResourceNotFoundException("Estudante não encontrado.")),HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(new ResponseData(estudante), HttpStatus.OK);
	}
	
	
	@PostMapping("/adicionar")
	public ResponseEntity<?> Adicionar(@RequestBody @Valid EstudanteModel request)
	{		
		EstudanteModel estudante = repository.save(request);
		return new ResponseEntity<>(new ResponseData(estudante), HttpStatus.CREATED);
	}
	
	
	@DeleteMapping("/remover/{id}")
	public ResponseEntity<?> Remover(@PathVariable("id") Long id)
	{	
		try {
			EstudanteModel estudante= repository.getOne(id);			
			if(!EstudanteValidation.validaIfEstudanteExiste(estudante)) {
				return new ResponseEntity<>(new ResponseData(new ResourceNotFoundException("Estudante não encontrado.")),HttpStatus.BAD_REQUEST);
			}
			repository.delete(estudante);
		}catch(Exception ex) {
			return new ResponseEntity<>(new ResponseData(new ResourceNotFoundException("Estudante não encontrado.")),HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity(HttpStatus.OK);
	}
	
	
	@PutMapping("/atualizar/")
	public ResponseEntity<?> Atualizar(@RequestBody @Valid EstudanteModel request)
	{	
		try {
			EstudanteModel estudante = repository.saveAndFlush(request);	
			return new ResponseEntity<>(new ResponseData(estudante), HttpStatus.OK);			
		}catch(Exception ex) {
			return new ResponseEntity<>(new ResponseData(new ResourceNotFoundException("Estudante não encontrado.")),HttpStatus.BAD_REQUEST);			
		}
	}
}
