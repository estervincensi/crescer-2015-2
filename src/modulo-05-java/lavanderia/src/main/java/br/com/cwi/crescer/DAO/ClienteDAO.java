package br.com.cwi.crescer.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.cwi.crescer.domain.Cliente;
import br.com.cwi.crescer.domain.Cliente.SituacaoCliente;

@Repository
public class ClienteDAO {
	@PersistenceContext
	private EntityManager em;

	public Cliente findById(Long id) {
		return em.find(Cliente.class, id);
	}

	public List<Cliente> findBySituacao(SituacaoCliente situacao) {
		return em.createQuery("FROM Cliente c WHERE c.situacao = :situacao", Cliente.class)
				.setParameter("situacao", situacao).getResultList();
	}

	@Transactional
	public Cliente save(Cliente cliente) {
		if (cliente.getIdCliente() == null) {
			em.persist(cliente);
			return cliente;
		}
		return em.merge(cliente);
	}

	@Transactional
	public void delete(Long id) {
		em.remove(em.getReference(Cliente.class, id));
	}

	public List<Cliente> listAll() {
		return em.createQuery("from Cliente", Cliente.class).getResultList();
	}

	public List<Cliente> listByName(String nome) {
		return em.createQuery("from Cliente c where c.nome like :nome", Cliente.class).setParameter("nome", nome+"%")
				.getResultList();
	}

}
