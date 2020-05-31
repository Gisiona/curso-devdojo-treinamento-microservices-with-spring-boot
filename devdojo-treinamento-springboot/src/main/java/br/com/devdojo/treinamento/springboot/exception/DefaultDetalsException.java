package br.com.devdojo.treinamento.springboot.exception;

import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class DefaultDetalsException extends RuntimeException{

	@JsonProperty("error")
	private String mensagem;

	public String getMensagem() {
		return mensagem;
	}

	public DefaultDetalsException(String mensagem) {
		this.mensagem = mensagem;
	}
}
