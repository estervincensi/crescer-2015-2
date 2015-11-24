package br.com.cwi.crescer.DAO;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.cwi.crescer.AbstractInfrastructureTest;
import br.com.cwi.crescer.domain.Cidade;

public class CidadeDAOTest extends AbstractInfrastructureTest{
	@Autowired
	CidadeDAO cidadeDAO;
	
	@Test
	public void deveBuscarCidadeporId() throws Exception {
		Cidade cidade = cidadeDAO.findById(1L);
        Assert.assertNotNull(cidade);
	}

}
