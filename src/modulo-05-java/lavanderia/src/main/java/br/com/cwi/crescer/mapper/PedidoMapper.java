package br.com.cwi.crescer.mapper;

import java.math.BigDecimal;
import java.util.Date;

import br.com.cwi.crescer.DTO.PedidoDTO;
import br.com.cwi.crescer.domain.Cliente;
import br.com.cwi.crescer.domain.Pedido;
import br.com.cwi.crescer.domain.Pedido.SituacaoPedido;

public class PedidoMapper {

	public static PedidoDTO toDTO(Pedido entity) {
		PedidoDTO dto = new PedidoDTO();
		dto.setCliente(entity.getCliente());
		dto.setDataEntrega(entity.getDataEntrega());
		dto.setDataInclusao(entity.getDataInclusao());
		dto.setSituacao(entity.getSituacao());
		dto.setValorBruto(entity.getValorBruto());
		dto.setValorDesconto(entity.getValorDesconto());
		dto.setValorFinal(entity.getValorFinal());
		dto.setIdPedido(entity.getIdPedido());
		dto.setItens(entity.getItens());
		return dto;
	}

	public static Pedido merge(PedidoDTO dto, Pedido entity) {
		entity.setCliente(dto.getCliente());
		entity.setDataEntrega(dto.getDataEntrega());
		entity.setDataInclusao(dto.getDataInclusao());
		entity.setIdPedido(dto.getIdPedido());
		entity.setValorBruto(dto.getValorBruto());
		entity.setValorDesconto(dto.getValorDesconto());
		entity.setValorFinal(dto.getValorFinal());
		return entity;
	
	}
	
	public static Pedido getNewEntity(Cliente cliente) {
        return new Pedido(cliente, new Date(), new BigDecimal(0), SituacaoPedido.PENDENTE);
    }

}
