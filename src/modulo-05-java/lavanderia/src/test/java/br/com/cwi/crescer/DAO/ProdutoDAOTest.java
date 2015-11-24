package br.com.cwi.crescer.DAO;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.cwi.crescer.AbstractInfrastructureTest;
import br.com.cwi.crescer.domain.Produto;

public class ProdutoDAOTest extends AbstractInfrastructureTest {

    @Autowired
    private ProdutoDAO produtoDAO;

    @Test
    public void deveBuscarProdutoPorId() throws Exception {
        Produto produto = produtoDAO.findById(1L);
        Assert.assertNotNull(produto);
        Assert.assertNotNull(produto.getServico());
        Assert.assertNotNull(produto.getMaterial());
    }
}