package br.com.stefanini.maratonadev.model.parser;

import br.com.stefanini.maratonadev.dto.ClienteDto;
import br.com.stefanini.maratonadev.model.Cliente;

/**
 * 
 * @author Renato Nobrega
 * @version 0.1.0
 * @created 01/11/2020 on 14:36
 */

public class ClienteParser {

	public static ClienteParser get() {
		return new ClienteParser();
	}

	public ClienteDto dto(Cliente entidade) {

		ClienteDto dto = new ClienteDto();
		dto.setId(entidade.getId());
		dto.setNome(entidade.getNome());
		dto.setCpf(entidade.getCpf());
		dto.setEmail(entidade.getEmail());
		dto.setLogradouro(entidade.getLogradouro());
		dto.setComplemento(entidade.getComplemento());
		dto.setBairro(entidade.getBairro());
		dto.setCidade(entidade.getBairro());
		dto.setContato(entidade.getContato());
		dto.setUf(entidade.getUf());

		return dto;
	}

	public Cliente entidade(ClienteDto dto) {

		Cliente entidade = new Cliente();
		entidade.setId(dto.getId());
		entidade.setNome(dto.getNome());
		entidade.setCpf(dto.getCpf());
		entidade.setEmail(dto.getEmail());
		entidade.setLogradouro(dto.getLogradouro());
		entidade.setComplemento(dto.getComplemento());
		entidade.setBairro(dto.getBairro());
		entidade.setCidade(dto.getCidade());
		entidade.setContato(dto.getContato());
		entidade.setUf(dto.getUf());

		return entidade;
	}
}
