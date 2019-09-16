package br.com.demospringboot.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Estudante")
public class Estudante extends EntityAbstractBase {

	
	private String nome;
	private String email;
	private String telefone;
	
}
