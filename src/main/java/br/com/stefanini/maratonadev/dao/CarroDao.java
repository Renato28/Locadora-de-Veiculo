package br.com.stefanini.maratonadev.dao;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import br.com.stefanini.maratonadev.model.Carro;
import io.quarkus.panache.common.Sort;

/**
 * 
 * @author Renato Nobrega
 * @version 0.1.0
 * @created 01/11/2020 on 14:46
 */

@RequestScoped
public class CarroDao {

	@PersistenceContext
	EntityManager manager;

	@Transactional
	public String inserir(Carro carro) {
		String nomeSql = "INSERIR_CARRO";
		carro.persistAndFlush();
		return carro.getPlaca();
	}

	@Transactional
	public void atualizar(Carro carro) {
		String nomeSql = "INSERIR_CARRO";
		inserirOuAtualizar(nomeSql, carro);
	}

	private void inserirOuAtualizar(String nomeSql, Carro carro) {
		Query query = manager.createNamedQuery(nomeSql);
		
		query.setParameter("placa", carro.getPlaca());
		query.setParameter("ano", carro.getAno());
		query.setParameter("marca", carro.getMarca());
		query.setParameter("modelo", carro.getModelo());
		query.executeUpdate();
	}

	public List<Carro> listar() {
		return Carro.listAll(Sort.by("modelo, marca").ascending());
	}

	public Carro buscarPorPlaca(String placa) {
		String nomeSql = "CONSULTAR_CARRO_ID";
		Carro carro;
		TypedQuery<Carro> query = manager.createNamedQuery(nomeSql, Carro.class);
		query.setParameter("placa", placa);
		try {
			carro = query.getSingleResult();
		} catch (NoResultException e) {
			carro = null;
		}

		return carro;
	}

	@Transactional
	public void excluir(String placa) {
		String nomeSQL = "EXCLUIR_CARRO";
		Query query = manager.createNamedQuery(nomeSQL);

		query.setParameter("placa", placa);

		query.executeUpdate();
	}
}
