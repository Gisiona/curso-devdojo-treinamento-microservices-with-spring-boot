package br.com.demospringboot.exception;


public class ExceptionDefault {

	private String mensagem;
	private String codigo;
	
	
	public String getCodigo() {
		return codigo;
	}

	public String getMensagem() {
		return mensagem;
	}
	
	public ExceptionDefault(String cod,String mens) {
		this.codigo = cod;
		this.mensagem = mens;
	}
	
}
