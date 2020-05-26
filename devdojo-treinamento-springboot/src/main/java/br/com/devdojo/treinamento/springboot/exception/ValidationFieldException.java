package br.com.devdojo.treinamento.springboot.exception;

public class ValidationFieldException extends RuntimeException{

	private int status;
	public int getStatus() {
		return status;
	}

	private String campo;
	private String mensagem;
	
	
	public ValidationFieldException(int status, String campo, String mensagem) {
		super();
		this.status = status;
		this.campo = campo;
		this.mensagem = mensagem;
	}
	
	public String getMensagem() {
		return mensagem;
	}
	
	public String getCampo() {
		return campo;
	}
}
