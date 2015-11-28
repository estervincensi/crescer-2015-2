package br.com.cwi.crescer.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.cwi.crescer.domain.Servico;

@Repository
public class ServicoDAO {
	@PersistenceContext
	private EntityManager em;
	
	public Servico findById(Long id) {
		return em.find(Servico.class, id);
	}

	public List<Servico> listAll() {
		return em.createQuery("FROM Servico", Servico.class).getResultList();
	}

}
