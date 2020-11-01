package br.com.stefanini.maratonadev.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.NotFoundException;

import br.com.stefanini.maratonadev.dao.ClienteDao;
import br.com.stefanini.maratonadev.dto.ClienteDto;
import br.com.stefanini.maratonadev.model.Cliente;
import br.com.stefanini.maratonadev.model.parser.ClienteParser;

/**
 * 
 * @author Renato Nobrega
 * @version 0.1.0
 * @created 01/11/2020 on 15:36
 */

@RequestScoped
public class ClienteService {

	@Inject
	ClienteDao dao;

	@Transactional(rollbackOn = Exception.class)
	private void validar(Cliente cliente) {
		if (cliente.getNome() == null) {
			throw new NotFoundException();
		}
	}

	public void cadastrar(ClienteDto dto) {
		Cliente cliente = ClienteParser.get().entidade(dto);
		validar(cliente);
	}

	public List<ClienteDto> listar() {
		return dao.listar().stream().map(ClienteParser.get()::dto).collect(Collectors.toList());
	}
	
	public void excluir(Long id) {
		dao.excluir(id);
	}
}
