package br.com.cwi.crescer.mapper;

import br.com.cwi.crescer.DTO.PedidoDTO;
import br.com.cwi.crescer.domain.Pedido;

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

}
