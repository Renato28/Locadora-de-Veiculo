package br.com.stefanini.maratonadev.dto;

/**
 * 
 * @author Renato Nobrega
 * @version 0.1.0
 * @created 01/11/2020 on 14:26
 *
 */

public class CarroDto {

	private String placa;

	private int ano;

	private String modelo;

	private String marca;

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

}
