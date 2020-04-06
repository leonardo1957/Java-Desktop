package model.entity;

public class Telefone {

	private Integer id;
	private String ddd;
	private String numero;
	private boolean movel;
	private boolean ativo;
	private String codigoPais;
	private Cliente dono;

	public Telefone(Integer id, String ddd, String numero, boolean movel, boolean ativo, String codPais, Cliente dono) {
		super();
		this.id = id;
		this.ddd = ddd;
		this.numero = numero;
		this.movel = movel;
		this.ativo = ativo;
		this.codigoPais = codPais;
		this.dono = dono;
	}

	public Telefone() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDdd() {
		return ddd;
	}

	public void setDdd(String ddd) {
		this.ddd = ddd;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public boolean isMovel() {
		return movel;
	}

	public void setMovel(boolean movel) {
		this.movel = movel;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public String getCodigoPais() {
		return codigoPais;
	}

	public void setCodigoPais(String codPais) {
		this.codigoPais = codPais;
	}

	public Cliente getDono() {
		return dono;
	}

	public void setDono(Cliente dono) {
		this.dono = dono;
	}

	@Override
	public String toString() {
		return "numero=" + numero;
	}

}
