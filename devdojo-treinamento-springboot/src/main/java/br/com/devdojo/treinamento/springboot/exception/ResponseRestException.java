package br.com.devdojo.treinamento.springboot.exception;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseRestException {

	private int status;
	
	@JsonProperty("error")
	private String mensagem;
	private Long tamestamp;
	private LocalDateTime datetime;
	
	public LocalDateTime getDatetime() {
		return datetime;
	}


	public int getStatus() {
		return status;
	}


	public String getMensagem() {
		return mensagem;
	}


	public Long getTamestamp() {
		return tamestamp;
	}	
	
	public ResponseRestException(int status, String mensagem, Long tamestamp, LocalDateTime date) {
		super();
		this.status = status;
		this.mensagem = mensagem;
		this.tamestamp = tamestamp;
		this.datetime = date;
	}
}
