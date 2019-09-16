package br.com.demospringboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.demospringboot.entity.Estudante;

public interface EstudanteRepository extends JpaRepository<Estudante, Long> {
	List<Estudante> findByNome(String nome);
}
 