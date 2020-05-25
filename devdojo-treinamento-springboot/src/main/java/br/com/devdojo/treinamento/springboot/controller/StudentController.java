package br.com.devdojo.treinamento.springboot.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RestController;

import br.com.devdojo.treinamento.springboot.model.StudentModel;
import br.com.devdojo.treinamento.springboot.processor.StudentProcessor;
import javassist.NotFoundException;

@RestController
@RequestMapping("/students")
public class StudentController {

	@Autowired
	private StudentProcessor studentProcessor;
	
	@GetMapping()
	public List<StudentModel> listAll(){		
		return studentProcessor.getAll();
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<StudentModel> studentsById(@PathVariable("id") Long id){		
		return ResponseEntity.ok().body(studentProcessor.getById(id));
	}
	
	@PostMapping()
	public ResponseEntity<?> saveStudent(@RequestBody StudentModel sts){
		StudentModel model = studentProcessor.save(sts);
		return new ResponseEntity<>(model, HttpStatus.CREATED); 
	}
	
	@PutMapping()
	public ResponseEntity<?> updateStudent(@RequestBody StudentModel sts) throws NotFoundException{		
		StudentModel model = studentProcessor.update(sts);
		return new ResponseEntity<>(model, HttpStatus.OK); 
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteStudent(@PathVariable("id") Long id) throws NotFoundException{		
		studentProcessor.delete(id);
		return new ResponseEntity<>(HttpStatus.OK); 
	}
}
