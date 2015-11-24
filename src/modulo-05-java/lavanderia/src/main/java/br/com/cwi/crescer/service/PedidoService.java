package br.com.cwi.crescer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.crescer.DAO.PedidoDAO;
import br.com.cwi.crescer.domain.Pedido.SituacaoPedido;

@Service
public class PedidoService {
private PedidoDAO pedidoDAO;
	
	@Autowired
	public PedidoService(PedidoDAO pedidoDAO){
		super();
		this.pedidoDAO = pedidoDAO;
	}
	
	public SituacaoPedido buscarSituacao(Long id){
		return pedidoDAO.findById(id).getSituacao();
	}
	
}
