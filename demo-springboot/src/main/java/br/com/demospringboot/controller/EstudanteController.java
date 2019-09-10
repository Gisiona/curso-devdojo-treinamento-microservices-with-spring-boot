package br.com.demospringboot.controller;

import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

	private List<Estudante> listaEstudantes = null;
	
	@GetMapping("/lista")
	public ResponseEntity<?> Listar()
	{
		Estudante estud = new Estudante(123L, "Gisiona Costa", "gisionacosta@hotmail.com", "(11) 97951-0575");
		listaEstudantes = new ArrayList();
		
		listaEstudantes.add(estud);		
		return new ResponseEntity<>(listaEstudantes, HttpStatus.OK);
	}
	
	
	@DeleteMapping("/remover/{id}")
	public ResponseEntity<?> Remover(@PathVariable("id") Integer id)
	{	
		try {
			Integer retorno = listaEstudantes.indexOf(id);			
			if(retorno == -1) {
				return new ResponseEntity<>(new ExceptionDefault(HttpStatus.NOT_FOUND.toString() , "O estudante informado não foi encontrado."), HttpStatus.NOT_FOUND);
			}
		}catch(Exception ex) {
			return new ResponseEntity<>(new ExceptionDefault(HttpStatus.BAD_REQUEST.toString() , "O estudante informado não foi encontrado."), HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity(HttpStatus.OK);
	}
}
