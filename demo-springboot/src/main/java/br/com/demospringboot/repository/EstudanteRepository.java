package br.com.demospringboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.demospringboot.model.EstudanteModel;

public interface EstudanteRepository extends JpaRepository<EstudanteModel, Long>  {
	List<EstudanteModel> findByNome(String nome);
}
 