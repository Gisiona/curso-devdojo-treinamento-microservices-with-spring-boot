package br.com.devdojo.treinamento.springboot.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.devdojo.treinamento.springboot.entity.Student;

@Repository
public interface StudentRepository extends PagingAndSortingRepository<Student, Long> {
	List<Student> findByNome(String nome);
}
