package br.com.cwi.crescer.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.cwi.crescer.domain.Material;

@Repository
public class MaterialDAO {
	@PersistenceContext
	private EntityManager em;
	
	public Material findById(Long id) {
		return em.find(Material.class, id);
	}

	public List<Material> listAll() {
		return em.createQuery("FROM Material", Material.class).getResultList();
	}

	
}
