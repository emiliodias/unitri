package br.com.unitri.estudos.vendas;

import java.util.UUID;

public class Usuario {
	
	
	private String id;
	
	private String nome;
	
	private String cpf;
	
	private int idade;
	
	public Usuario() {
		
		UUID id = UUID.randomUUID();
		
		this.id = id.toString();
		
	}
	
	public String getId() {
		return id;
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

	public int getIdade() {
		return this.idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

}
