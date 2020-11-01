package br.com.stefanini.maratonadev.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.NotFoundException;

import br.com.stefanini.maratonadev.dao.CarroDao;
import br.com.stefanini.maratonadev.dto.CarroDto;
import br.com.stefanini.maratonadev.model.Carro;
import br.com.stefanini.maratonadev.model.parser.CarroParser;

/**
 * 
 * @author Renato Nobrega
 * @version 0.1.0
 * @created 01/11/2020 on 15:31
 */

@RequestScoped
public class CarroService {

	@Inject
	CarroDao dao;

	@Transactional(rollbackOn = Exception.class)
	private void validar(Carro carro) {
		if (carro.getPlaca() == null) {
			throw new NotFoundException();
		}
	}

	public void cadastrar(CarroDto dto) {
		Carro carro = CarroParser.get().entidade(dto);
		validar(carro);
	}

	public List<CarroDto> listar() {
		return dao.listar().stream().map(CarroParser.get()::dto).collect(Collectors.toList());
	}

	public void excluir(String placa) {
		dao.excluir(placa);
	}
}
