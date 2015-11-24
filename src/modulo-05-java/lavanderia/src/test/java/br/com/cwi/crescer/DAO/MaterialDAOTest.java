package br.com.cwi.crescer.DAO;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.cwi.crescer.AbstractInfrastructureTest;
import br.com.cwi.crescer.domain.Material;

public class MaterialDAOTest extends AbstractInfrastructureTest {

    @Autowired
    private MaterialDAO materialDAO;

    @Test
    public void deveBuscarMaterialPorId() throws Exception {
        Material material = materialDAO.findById(1L);
        Assert.assertNotNull(material);
    }
}
