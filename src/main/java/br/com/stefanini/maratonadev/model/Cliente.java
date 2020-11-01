package br.com.stefanini.maratonadev.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

/**
 * 
 * @author Renato Nobrega
 * @version 0.1.0
 * @Created 01/11/2020 on 13:28
 */

@Entity
@Table(name = "cliente")
@NamedNativeQueries({ @NamedNativeQuery(name = "CONSULTAR_CLIENTE", query = ""
		+ "SELECT id, nome, cpf, cep, logradouro, complemento, bairro, cidade, uf, email, contato FROM cliente", resultClass = Cliente.class),
		@NamedNativeQuery(name = "INSERIR_CLIENTE", query = ""
				+ "INSERT INTO cliente (nome, cpf, cep, logradouro, complemento, bairro, cidade, uf, email, contato) values "
				+ "(:nome, :cpf, :cep, :logradouro, :complemento, :bairro, :cidade, :uf, :email, :contato)"),
		@NamedNativeQuery(name = "EXCLUIR_CLIENTE", query = "DELETE cliente WHERE id = :id"),
		@NamedNativeQuery(name = "CONSULTAR_CPF_REPETIDO_CLIENTE", query = ""
				+ "SELECT id, nome, cpf, logradouro, complemento, bairro, cidade, uf, email, contato FROM cliente WHERE cpf like :cpf", resultClass = Cliente.class),
		@NamedNativeQuery(name = "CONSULTAR_CLIENTE_ID)", query = ""
				+ "SELECT id, nome, cpf, cep, logradouro, complemento, bairro, cidade, uf, contato FROM cliente WHERE id = :id", resultClass = Cliente.class),
		@NamedNativeQuery(name = "ATUALIZAR_CLIENTE", query = "UPDATE cliente"
				+ "set nome = :nome, cpf = :cpf, cep = :cep, logradouro = :logradouro, complemento = :complemento, bairro = :bairro, cidade = :cidade, uf = :uf, email = :email, contato = :contato WHERE id = :id") })
public class Cliente extends PanacheEntityBase {

	@Id
	private Long id;

	@NotEmpty(message = "Preenchimento obrigatório")
	@Length(min = 3, max = 100)
	@Column(name = "nome", nullable = false)
	private String nome;

	@NotEmpty(message = "Preenchimento obrigatório")
	@Column(name = "cpf", nullable = false)
	@CPF
	private String cpf;

	@Column(name = "cep")
	private String cep;

	@Column(name = "logradouro")
	private String logradouro;

	@Column(name = "complemento")
	private String complemento;

	@Column(name = "bairro")
	private String bairro;

	@Column(name = "cidade")
	private String cidade;

	@Column(name = "uf")
	private String uf;

	@Column(name = "email")
	private String email;

	@Valid
	@Column(name = "contato")
	private String contato;

	@JoinColumn(name = "fk_carro_id", nullable = false)
	private Carro carro;

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

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	public Carro getCarro() {
		return carro;
	}

	public void setCarro(Carro carro) {
		this.carro = carro;
	}

}
