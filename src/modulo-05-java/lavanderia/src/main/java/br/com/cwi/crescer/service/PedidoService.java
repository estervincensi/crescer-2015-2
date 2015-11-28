package br.com.cwi.crescer.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.crescer.DAO.PedidoDAO;
import br.com.cwi.crescer.DTO.PedidoDTO;
import br.com.cwi.crescer.domain.Pedido;
import br.com.cwi.crescer.mapper.PedidoMapper;

@Service
public class PedidoService {
	private PedidoDAO pedidoDAO;

	@Autowired
	public PedidoService(PedidoDAO pedidoDAO) {
		super();
		this.pedidoDAO = pedidoDAO;
	}

	public List<PedidoDTO> listarPedidos() {
		List<Pedido> pedidos = pedidoDAO.listAll();
		List<PedidoDTO> dtos = new ArrayList<PedidoDTO>();
		for (Pedido pedido : pedidos) {
			dtos.add(new PedidoDTO(pedido));
		}
		return dtos;
	}

	public PedidoDTO buscarPedidoPorId(Long id) {
		Pedido entity = pedidoDAO.findById(id);
		return PedidoMapper.toDTO(entity);
	}

	public List<PedidoDTO> listarPedidosPorCpf(String cpf) {
		List<Pedido> pedidos = pedidoDAO.listarPorCpf(cpf);
		List<PedidoDTO> dtos = new ArrayList<PedidoDTO>();
		for (Pedido pedido : pedidos) {
			dtos.add(new PedidoDTO(pedido));
		}
		return dtos;
	}

	public List<PedidoDTO> listarPedidosPorCpfeSituacao(String cpf, String situacao) {
		List<Pedido> pedidos = pedidoDAO.listarPorCpfESituacao(cpf,situacao);
		List<PedidoDTO> dtos = new ArrayList<PedidoDTO>();
		for (Pedido pedido : pedidos) {
			dtos.add(new PedidoDTO(pedido));
		}
		return dtos;
	}

	public List<PedidoDTO> listarPedidosPorSituacao(String situacao) {
		List<Pedido> pedidos = pedidoDAO.listarPorSituacao(situacao);
		List<PedidoDTO> dtos = new ArrayList<PedidoDTO>();
		for (Pedido pedido : pedidos) {
			dtos.add(new PedidoDTO(pedido));
		}
		return dtos;
	}
}
