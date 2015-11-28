package br.com.cwi.crescer.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.cwi.crescer.domain.Pedido;
import br.com.cwi.crescer.domain.Pedido.SituacaoPedido;

@Repository
public class PedidoDAO {

	@PersistenceContext
	private EntityManager em;

	public Pedido findById(Long id) {
		return em.find(Pedido.class, id);
	}

	public List<Pedido> listAll() {
		return em.createQuery("from Pedido", Pedido.class).getResultList();
	}

	public List<Pedido> listarPorCpf(String cpf) {
		return em.createQuery("from Pedido p where p.cliente.cpf = :cpf", Pedido.class).setParameter("cpf", cpf)
				.getResultList();
	}

	public List<Pedido> listarPorCpfESituacao(String cpf, String situacao) {
		return em.createQuery("from Pedido p where p.cliente.cpf = :cpf and p.situacao = :situacao", Pedido.class)
				.setParameter("cpf", cpf).setParameter("situacao", SituacaoPedido.valueOf(situacao)).getResultList();
	}

	public List<Pedido> listarPorSituacao(String situacao) {
		return em.createQuery("from Pedido p where p.situacao = :situacao", Pedido.class)
				.setParameter("situacao", SituacaoPedido.valueOf(situacao)).getResultList();
	}
}
