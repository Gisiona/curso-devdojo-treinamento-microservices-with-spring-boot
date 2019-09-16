package br.com.demospringboot.model;

public class EstudanteModel {

	private Long Id;
	private String Nome;
	private String Email;
	private String Telefone;
	
	public EstudanteModel() {
		
	}
	
	public EstudanteModel(Long id, String nome, String email, String telefone) {
		this.Id = id;
		this.Nome = nome;
		this.Email = email;
		this.Telefone = telefone;
	}
	
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getTelefone() {
		return Telefone;
	}
	public void setTelefone(String telefone) {
		Telefone = telefone;
	}
	
}
