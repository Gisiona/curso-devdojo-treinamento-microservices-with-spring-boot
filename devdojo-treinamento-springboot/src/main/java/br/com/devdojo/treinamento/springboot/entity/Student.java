package br.com.devdojo.treinamento.springboot.entity;

import javax.persistence.Entity;

@Entity
public class Student extends AbstractEntity{

	private String nome;
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
