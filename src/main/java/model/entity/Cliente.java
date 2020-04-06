package model.entity;

import java.util.List;

public class Cliente {
	
	private Integer id;
	private String nome;
	private String sobrenome;
	private String cpf;
	private Endereco endereco;
	private List<Telefone> telefones;
	
	public Cliente(Integer id, String nome, String sobrenome, String cpf, Endereco endereco, List<Telefone> telefones) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.endereco = endereco;
		this.telefones = telefones;
	}

	public Cliente() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public List<Telefone> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}

	@Override
	public String toString() {
		return nome + " cpf=" + cpf;
	}

}
