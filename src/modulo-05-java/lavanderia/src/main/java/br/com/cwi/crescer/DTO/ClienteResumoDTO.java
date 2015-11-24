package br.com.cwi.crescer.DTO;

import br.com.cwi.crescer.domain.Cliente;

public class ClienteResumoDTO {
	private Long id;
	private String nome;
	private String cpf;
	private String email;

	public ClienteResumoDTO() {
	}

	public ClienteResumoDTO(Long id, String nome, String cpf, String email) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
	}
	
	public ClienteResumoDTO(Cliente entity){
		this.id = entity.getIdCliente();
		this.nome = entity.getNome();
		this.cpf = entity.getCpf();
		this.email = entity.getEmail();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
