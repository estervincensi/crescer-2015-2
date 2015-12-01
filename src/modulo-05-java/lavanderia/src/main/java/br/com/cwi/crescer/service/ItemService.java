package br.com.cwi.crescer.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.crescer.DAO.ItemDAO;
import br.com.cwi.crescer.DAO.PedidoDAO;
import br.com.cwi.crescer.DAO.ProdutoDAO;
import br.com.cwi.crescer.DTO.ItemDTO;
import br.com.cwi.crescer.domain.Item;
import br.com.cwi.crescer.domain.Item.SituacaoItem;
import br.com.cwi.crescer.domain.Material;
import br.com.cwi.crescer.domain.Produto;
import br.com.cwi.crescer.domain.Servico;
import br.com.cwi.crescer.mapper.ItemMapper;

@Service
public class ItemService {
	private ItemDAO itemDAO;
	private PedidoDAO pedidoDAO;
	private ProdutoDAO produtoDAO;

	@Autowired
	public ItemService(ItemDAO itemDAO, PedidoDAO pedidoDAO, ProdutoDAO produtoDAO) {
		super();
		this.itemDAO = itemDAO;
		this.pedidoDAO = pedidoDAO;
		this.produtoDAO = produtoDAO;
	}

	public SituacaoItem buscarSituacao(Long id) {
		return itemDAO.findById(id).getSituacao();
	}

	public Item incluirItem(ItemDTO itemDTO) {
		Produto produto = obterProduto(itemDTO);

		Item item = ItemMapper.getNewEntity(itemDTO);
		item.setValorUnitario(produto.getValor());
		item.setPedido(pedidoDAO.findById(itemDTO.getIdPedido()));
		item.setProduto(produto);
		item.setPeso(itemDTO.getPeso());
		BigDecimal valorTotal = item.getValorUnitario().multiply(item.getPeso());
		item.setValorTotal(valorTotal);
		item.setSituacao(SituacaoItem.PENDENTE);

		return itemDAO.save(item);

	}

	private Produto obterProduto(ItemDTO itemDTO) {
		Produto produtoBuscar = new Produto();
		produtoBuscar.setMaterial(new Material());
		produtoBuscar.setServico(new Servico());
		produtoBuscar.getMaterial().setIdMaterial(itemDTO.getIdMaterial());
		produtoBuscar.getServico().setIdServico(itemDTO.getIdServico());
		Produto produto = produtoDAO.buscarPorMaterialeServico(produtoBuscar);
		return produto;
	}

	public void alterarSituacao(Long idItem) {
		Item item = itemDAO.findById(idItem);
		item.setSituacao(SituacaoItem.PROCESSADO);
		itemDAO.save(item);
	}

}
