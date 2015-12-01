package br.com.cwi.crescer.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import br.com.cwi.crescer.DAO.ClienteDAO;
import br.com.cwi.crescer.DAO.PedidoDAO;
import br.com.cwi.crescer.domain.Item;
import br.com.cwi.crescer.domain.Pedido;
import br.com.cwi.crescer.domain.Produto;

@RunWith(MockitoJUnitRunner.class)
public class PedidoServiceTest {
	@Mock
	private ClienteDAO clienteDAO;

	@Mock
	private PedidoDAO pedidoDAO;
	@InjectMocks
	private PedidoService pedidoService;
	
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testVerificarDesconto() throws Exception {
		Pedido pedido = new Pedido();
		Item item = new Item();
		item.setPeso(new BigDecimal(10));
		ArrayList<Item> itens = new ArrayList<Item>();
		itens.add(item);
		item.setPeso(new BigDecimal(4));
		pedido.setDataInclusao(new Date());
		pedido.setValorBruto(new BigDecimal(100));
		pedido.setItens(itens);
		BigDecimal valor = pedidoService.verificarDesconto(pedido, item);
		Assert.assertEquals(8.0, valor.doubleValue(), 0.003);
		
	}

	@Test
	public void testSomarPesos() throws Exception {
		Pedido pedido = new Pedido();
		Item item1 = new Item();
		item1.setPeso(new BigDecimal(2));
		Item item2 = new Item();
		item2.setPeso(new BigDecimal(2));
		ArrayList<Item>itens = new ArrayList<Item>();
		itens.add(item1);
		itens.add(item2);
		pedido.setItens(itens);
		BigDecimal valor =  pedidoService.somarPesos(pedido);
		Assert.assertEquals(4.0,valor.doubleValue(),0.003);
	}
	
	@Test
	public void testAtualizarData(){
		Pedido pedido = new Pedido();
		Item item = new Item();
		Produto produto = new Produto();
		produto.setPrazo(4);
		pedido.setDataInclusao(new Date());
		item.setProduto(produto);
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DAY_OF_MONTH, 4);
		Assert.assertEquals(c.getTime(), pedidoService.atualizarData(item, pedido));
	}
	
	@Test
	public void testObterValorBrutoAtual(){
		Pedido pedido = new Pedido();
		pedido.setValorBruto(new BigDecimal(10));
		Item item = new Item();
		item.setValorTotal(new BigDecimal(10));
		Assert.assertEquals(20.0, pedidoService.obterValorBrutoAtual(item, pedido).doubleValue(),0.03);
	}
	@Test
	public void testAtualizarSituacao() throws Exception {
		//não testei pq ele recebe um idDoPedido e altera a situação, não consegui pensar em testes possiveis
	}

	@Test
	public void testRetirar() throws Exception {
		//não testei pq ele recebe um idDoPedido e altera a situação, não consegui pensar em testes possiveis
	}

	@Test
	public void testCancelar() throws Exception {
		//não testei pq ele recebe um idDoPedido e altera a situação, não consegui pensar em testes possiveis
	}
	
	@Test
	public void testProcessarPedido() throws Exception {
		//não testei pq ele recebe um idDoPedido e altera a situação, não consegui pensar em testes possiveis
	}
	
	

}
