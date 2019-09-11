package br.com.demospringboot.controller;

import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;
import javax.validation.Valid;

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
import br.com.demospringboot.model.Estudante;

@RestController
@ResponseBody
@RequestMapping("/api/v1/estudantes")
public class EstudanteController {

	private List<Estudante> listaEstudantes = new ArrayList();
	
	
	@GetMapping("/listar")
	public ResponseEntity<?> Listar()
	{	
		return new ResponseEntity<>(new ResponseData(listaEstudantes), HttpStatus.OK);
	}
	
	
	@GetMapping("/listar/{id}")
	public ResponseEntity<?> ListarPorId(@PathVariable("id") Integer id )
	{	
		Estudante estudante = listaEstudantes.get(1);
		return new ResponseEntity<>(new ResponseData(estudante), HttpStatus.OK);
	}
	
	
	@PostMapping("/adicionar")
	public ResponseEntity<?> Adicionar(@RequestBody @Valid Estudante request)
	{		
		listaEstudantes.add(request);		
		return new ResponseEntity<>(new ResponseData(request), HttpStatus.CREATED);
	}
	
	
	@DeleteMapping("/remover/{id}")
	public ResponseEntity<?> Remover(@PathVariable("id") Integer id)
	{	
		try {
			Integer retorno = listaEstudantes.indexOf(id);			
			if(retorno == -1) {
				return new ResponseEntity<>(new ResponseData(new ExceptionDefault(HttpStatus.NOT_FOUND.toString() , "O estudante informado não foi encontrado.")), HttpStatus.NOT_FOUND);
			}
		}catch(Exception ex) {
			return new ResponseEntity<>(new ResponseData(new ExceptionDefault(HttpStatus.NOT_FOUND.toString() , "O estudante informado não foi encontrado.")), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(HttpStatus.OK);
	}
	
	
	@PutMapping("/atualizar/{id}")
	public ResponseEntity<?> Atualizar(@PathVariable("id") Integer id, @RequestBody @Valid Estudante request)
	{	
		try {
			Integer retorno = listaEstudantes.indexOf(id);			
			if(retorno == -1) {
				return new ResponseEntity<>(new ResponseData(new ExceptionDefault(HttpStatus.NOT_FOUND.toString() , "O estudante informado não foi encontrado.")), HttpStatus.NOT_FOUND);
			}else {
				listaEstudantes.remove(retorno);
			}
			
			listaEstudantes.add(request);			
			return new ResponseEntity<>(new ResponseData(request), HttpStatus.OK);
			
		}catch(Exception ex) {
			return new ResponseEntity<>(new ResponseData(new ExceptionDefault(HttpStatus.NOT_FOUND.toString() , "Ocorreu uma falha. Não foi possível atualizar o estudante. Tente novamente mais tarde.")), HttpStatus.NOT_FOUND);			
		}
	}
}
