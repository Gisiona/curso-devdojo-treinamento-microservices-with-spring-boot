package br.com.devdojo.treinamento.springboot.exception;

public abstract class DefaultDetalsException extends RuntimeException{

	private String mensagem;

	public String getMensagem() {
		return mensagem;
	}

	public DefaultDetalsException(String mensagem) {
		this.mensagem = mensagem;
	}
}
