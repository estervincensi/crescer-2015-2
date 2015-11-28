package br.com.cwi.crescer.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.cwi.crescer.domain.Produto;

@Repository
public class ProdutoDAO {
	@PersistenceContext
	private EntityManager em;

	public Produto findById(Long id) {
		return em.find(Produto.class, id);
	}

	public List<Produto> listAll() {
		return em.createQuery("from Produto", Produto.class).getResultList();
	}

	public List<Produto> verificarSeExiste(Long idServico, Long idMaterial) {
		return em
				.createQuery(
						"from Produto p where p.servico.idServico = :idServico  and p.material.idMaterial = :idMaterial",
						Produto.class)
				.setParameter("idServico", idServico).setParameter("idMaterial", idMaterial).getResultList();
	}

	@Transactional
	public Produto save(Produto produto) {
		if (produto.getIdProduto() == null) {
			em.persist(produto);
			return produto;
		}
		return em.merge(produto);
	}

	public List<Produto> listarPorMaterialEServico(String material, String servico) {
		return em
				.createQuery("from Produto p where p.servico.descricao = :servico and p.material.descricao = :material",
						Produto.class).setParameter("material", material).setParameter("servico", servico)
				.getResultList();
	}

}
