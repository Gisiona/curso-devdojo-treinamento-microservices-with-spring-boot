package br.com.devdojo.treinamento.springboot.processor;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.devdojo.treinamento.springboot.entity.Student;
import br.com.devdojo.treinamento.springboot.exception.ResourceNotFounfException;
import br.com.devdojo.treinamento.springboot.model.StudentModel;
import br.com.devdojo.treinamento.springboot.repository.StudentRepository;
import javassist.NotFoundException;

@Component
public class StudentProcessor{

	@Autowired
	private StudentRepository studentRepository;

	public List<StudentModel> getAll() {		
		List<Student> students = studentRepository.findAll();
		return StudentModel.mapperConverter(students);
	}

	public StudentModel getById(Long id) {
		Student student = studentRepository.findById(id).get();
		return StudentModel.mapperConverter(student);
	}

	public StudentModel save(StudentModel sts) {
		Student student = sts.converterToStudent();
		student = studentRepository.save(student);		
		return StudentModel.mapperConverter(student);
	}

	public StudentModel update(StudentModel sts) throws NotFoundException {
		Optional<Student> student = studentRepository.findById(sts.getId());
		if(student.isPresent()) {
			Student studentUpdate = sts.converterToStudent();
			studentUpdate.setId(student.get().getId());
			studentUpdate = studentRepository.saveAndFlush(studentUpdate);		
			return StudentModel.mapperConverter(studentUpdate);
		}
		throw new ResourceNotFounfException("Student não localizado.");		
	}

	public void delete(Long id) throws NotFoundException {
		Optional<Student> student = studentRepository.findById(id);
		if(student.isPresent()) {
			studentRepository.delete(student.get());
		}else {
			throw new ResourceNotFounfException("Student não localizado.");
		}		
	}
}
