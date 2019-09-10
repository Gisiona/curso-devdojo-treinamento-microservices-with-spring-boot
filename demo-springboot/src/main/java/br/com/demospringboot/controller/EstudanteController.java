package br.com.demospringboot.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.demospringboot.model.Estudante;

@RestController
@ResponseBody
@RequestMapping("/api/v1/estudantes")
public class EstudanteController {

	private List<Estudante> listaEstudantes = null;
	
	@GetMapping("/lista")
	public List<Estudante> Listar()
	{
		Estudante estud = new Estudante(123L, "Gisiona Costa", "gisionacosta@hotmail.com", "(11) 97951-0575");
		listaEstudantes = new ArrayList();
		
		listaEstudantes.add(estud);		
		return listaEstudantes;
	}
	
	
	@GetMapping("/remover")
	public String Remover(Integer id)
	{	
		listaEstudantes.remove(id);		
		return "Estudante removido com sucesso";
	}
}
