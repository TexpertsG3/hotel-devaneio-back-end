package hotel;

public class DadosHotel {
	
	private Integer idDadosHotel;
	private String nome;
	private Endereco endereco;
	private String cnpj;
	private String email;
	private String telefone;

	public DadosHotel(String nome, Endereco endereco, String cnpj, String email, String telefone) {
		this.nome = nome;
		this.endereco = endereco;
		this.cnpj = cnpj;
		this.email = email;
		this.telefone = telefone;
	}
	
	public Integer getIdDadosHotel() {
		return idDadosHotel;
	}
	
	public void setIdDadosHotel(Integer idDadosHotel) {
		this.idDadosHotel = idDadosHotel;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

}
