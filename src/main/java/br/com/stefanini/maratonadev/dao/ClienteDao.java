package br.com.stefanini.maratonadev.dao;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import br.com.stefanini.maratonadev.model.Cliente;
import io.quarkus.panache.common.Sort;

/**
 * 
 * @author Renato Nobrega
 * @version 0.1.0
 * @created 01/01/2020
 */

@RequestScoped
public class ClienteDao {

	@PersistenceContext
	EntityManager manager;

	public Long inserir(Cliente cliente) {
		String nomeSql = "INSERIR_CLIENTE";
		cliente.persistAndFlush();
		return cliente.getId();
	}

	public void atualizar(Cliente cliente) {
		String nomeSql = "INSERIR_CLIENTE";
		inserirOuAtualizar(nomeSql, cliente);
	}

	private void inserirOuAtualizar(String nomeSql, Cliente cliente) {

		Query query = manager.createNamedQuery(nomeSql);

		query.setParameter("id", cliente.getId());
		query.setParameter("nome", cliente.getNome());
		query.setParameter("cpf", cliente.getCpf());
		query.setParameter("cep", cliente.getCep());
		query.setParameter("email", cliente.getEmail());
		query.setParameter("logradouro", cliente.getLogradouro());
		query.setParameter("complemento", cliente.getComplemento());
		query.setParameter("bairro", cliente.getBairro());
		query.setParameter("cidade", cliente.getCidade());
		query.setParameter("uf", cliente.getUf());
		query.setParameter("contato", cliente.getContato());
	}

	public Cliente buscarPorId(Long id) {
		String nomeSql = "CONSULTAR_CLIENTE";
		Cliente cliente;
		TypedQuery<Cliente> query = manager.createNamedQuery(nomeSql, Cliente.class);
		query.setParameter("id", id);
		try {
			cliente = query.getSingleResult();
		} catch (NoResultException e) {
			cliente = null;
		}

		return cliente;
	}
	
	public List<Cliente> listar(){
		return Cliente.listAll(Sort.by("nome").ascending());
	}
	
	@Transactional
	public void excluir(Long id) {
		String nomeSQL = "EXCLUIR_CLIENTE";
		Query query = manager.createNamedQuery(nomeSQL);
		
		query.setParameter("id", id);
		
		query.executeUpdate();
	}
}
