package br.com.devdojo.treinamento.springboot.model;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import br.com.devdojo.treinamento.springboot.entity.Student;

public class StudentModel {

	private Long id;
	@NotEmpty(message = "O campo nome não pode ser nulo.")	
	private String nome;
	
	@Email(message = "Digite um e-mail válido.")
	@NotEmpty(message = "O campo e-mail não pode ser nulo.")
	private String email;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public StudentModel(Long id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public static List<StudentModel> mapperConverter(List<Student> students) {
		StudentModel model = null;
		List<StudentModel> models = new ArrayList<StudentModel>();
		for (Student student : students) {
			model = new StudentModel(student.getId() ,student.getNome());
			models.add(model);
		}
		return models;
	}

	public static StudentModel mapperConverter(Student student) {
		StudentModel model = new StudentModel(student.getId(), student.getNome());
		return model;
	}

	public Student converterToStudent() {
		Student sts = new Student();
		sts.setNome(this.nome);
		return sts;
	}
}
