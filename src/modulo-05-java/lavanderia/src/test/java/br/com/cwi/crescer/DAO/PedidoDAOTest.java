package br.com.cwi.crescer.DAO;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.cwi.crescer.AbstractInfrastructureTest;
import br.com.cwi.crescer.domain.Pedido;
import br.com.cwi.crescer.domain.Pedido.SituacaoPedido;

public class PedidoDAOTest extends AbstractInfrastructureTest {

	@Autowired
	private PedidoDAO pedidoDAO;

	@Test
	public void deveBuscarPedidoPorId() throws Exception {
		Pedido pedido = pedidoDAO.findById(1L);
		Assert.assertNotNull(pedido);
	}

	@Test
	public void deveBuscarPedidoPorIdComCliente() throws Exception {
		Pedido pedido = pedidoDAO.findById(1L);
		Assert.assertNotNull(pedido);
		Assert.assertNotNull(pedido.getCliente());
		Assert.assertNotNull(pedido.getItens());
	}

	@Test
	public void deveBuscarPedidosPendentes() throws Exception {
		List<Pedido> pedidos = pedidoDAO.findBySituacao(SituacaoPedido.PENDENTE);
		Assert.assertNotNull(pedidos);
		Assert.assertFalse(pedidos.isEmpty());

		for (Pedido pedido : pedidos) {
			Assert.assertEquals(SituacaoPedido.PENDENTE, pedido.getSituacao());
		}
	}
}