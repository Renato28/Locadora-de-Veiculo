package br.com.stefanini.maratonadev.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

/**
 * 
 * @author Renato Nobrega
 * @version 0.1.0
 * @created 01/11/2020 on 13:21
 *
 */

@Entity
@Table(name = "carro")
@NamedNativeQueries({
		@NamedNativeQuery(name = "CONSULTAR_CARRO", query = ""
				+ "SELECT placa, ano, modelo, marca FROM carro", resultClass = Carro.class),
		@NamedNativeQuery(name = "INSERIR_CARRO", query = "" + "INSERT INTO carro (placa, ano, modelo, marca) values "
				+ "(:placa, :ano, :modelo, :marca)"),
		@NamedNativeQuery(name = "EXCLUIR_CARRO", query = "DELETE carro WHERE id = :id"),
		@NamedNativeQuery(name = "CONSULTAR_CARRO_ID", query = ""
				+ "SELECT placa, ano, modelo, marcar FROM carro where id = :id", resultClass = Carro.class),
		@NamedNativeQuery(name = "ATUALIZAR_CARRO", query = "UPDATE carro "
				+ "set placa = :placa, ano = :ano, modelo = :modelo, marca = :marca WHERE id = :id"), })
public class Carro extends PanacheEntityBase {

	@Id
	private String placa;

	@Column(name = "ano")
	private int ano;

	@Column(name = "modelo")
	private String modelo;

	@Column(name = "marca")
	private String marca;

	@OneToMany(mappedBy = "carro", cascade = CascadeType.ALL)
	private List<StatusAluguel> status;

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public List<StatusAluguel> getStatus() {
		return status;
	}

	public void setStatus(List<StatusAluguel> status) {
		this.status = status;
	}

}
