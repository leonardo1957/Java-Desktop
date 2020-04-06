package model.entity;

public class Endereco {
	
	private Integer id;
	private String rua;
	private int cep;
	private String estado;
	private String bairro;
	private String cidade;
	private int numero;
	
	public Endereco(Integer id, String rua, int cep, String bairro, String estado, String cidade, int numero) {
		super();
		this.id = id;
		this.rua = rua;
		this.cep = cep;
		this.estado = estado;
		this.cidade = cidade;
		this.numero = numero;
	}

	public Endereco() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public int getCep() {
		return cep;
	}

	public void setCep(int cep) {
		this.cep = cep;
	}
	
	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	@Override
	public String toString() {
		return "Endereco [id=" + id + ", rua=" + rua + ", cep=" + cep + ", estado=" + estado + ", bairro=" + bairro
				+ ", cidade=" + cidade + "]";
	}
}
