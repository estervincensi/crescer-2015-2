package br.com.cwi.crescer.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.crescer.DAO.ClienteDAO;
import br.com.cwi.crescer.DAO.PedidoDAO;
import br.com.cwi.crescer.DTO.PedidoResumidoDTO;
import br.com.cwi.crescer.DTO.PedidoDTO;
import br.com.cwi.crescer.DTO.PedidoResumoDTO;
import br.com.cwi.crescer.domain.Cliente;
import br.com.cwi.crescer.domain.Item;
import br.com.cwi.crescer.domain.Item.SituacaoItem;
import br.com.cwi.crescer.domain.Pedido;
import br.com.cwi.crescer.domain.Pedido.SituacaoPedido;
import br.com.cwi.crescer.mapper.PedidoMapper;

@Service
public class PedidoService {
	private PedidoDAO pedidoDAO;
	private ClienteDAO clienteDAO;

	@Autowired
	public PedidoService(PedidoDAO pedidoDAO, ClienteDAO clienteDAO) {
		super();
		this.pedidoDAO = pedidoDAO;
		this.clienteDAO = clienteDAO;
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

	public void processarPedido(PedidoResumidoDTO dto) {
		Pedido entity = pedidoDAO.findById(dto.getId());
		entity.setSituacao(SituacaoPedido.PROCESSADO);
		for(Item item : entity.getItens()){
			item.setSituacao(SituacaoItem.PROCESSADO);
		}
		pedidoDAO.save(entity);
	}

	public BigDecimal verificarDesconto(Pedido pedido, Item item){
		BigDecimal desconto8PorCento = new BigDecimal(0.08);
		BigDecimal desconto4PorCento = new BigDecimal(0.04);
		BigDecimal desconto4e87PorCento = new BigDecimal(0.0487);
		
		BigDecimal valorParaDesconto = new BigDecimal(90);
		BigDecimal pesoParaDesconto = new BigDecimal(15);
		
		BigDecimal pesoTotal = somarPesos(pedido);
		//pesoTotal = pesoTotal.add(item.getPeso());
		
		Calendar c = Calendar.getInstance();
		c.setTime(pedido.getDataInclusao());
		if(c.get(Calendar.DAY_OF_WEEK) == 2 || c.get(Calendar.DAY_OF_WEEK) == 3 || c.get(Calendar.DAY_OF_WEEK) == 4){
			return pedido.getValorBruto().multiply(desconto8PorCento);
		}
		if(c.get(Calendar.DAY_OF_WEEK) == 5 || c.get(Calendar.DAY_OF_WEEK) == 6){
			return pedido.getValorBruto().multiply(desconto4PorCento);
		}
		if(pedido.getValorBruto().compareTo(valorParaDesconto)>0 || pesoTotal.compareTo(pesoParaDesconto)>0){
			return pedido.getValorBruto().multiply(desconto4e87PorCento);
		}
		return new BigDecimal(0);
	}
	
	public BigDecimal somarPesos(Pedido pedido){
		BigDecimal pesos = new BigDecimal(0);
		for(Item item: pedido.getItens()){
			pesos = pesos.add(item.getPeso());
		}
		return pesos;
	}
	
	public Date atualizarData(Item item, Pedido pedido){
		Date dataEntrega = pedido.getDataInclusao();
		Calendar c = Calendar.getInstance();
		c.setTime(dataEntrega);
		c.add(Calendar.DAY_OF_MONTH, item.getProduto().getPrazo());
		dataEntrega = c.getTime();
		return dataEntrega;
	}

	public Pedido incluirInicial(PedidoResumoDTO pedidoResumo) {
		Cliente cliente = clienteDAO.findById(pedidoResumo.getIdCliente());
		Pedido pedido = new Pedido();
		pedido.setCliente(cliente);
		Date dataInclusao = new Date();
		pedido.setDataInclusao(dataInclusao);
		BigDecimal valorInicial = new BigDecimal(0); //valor inicial porque não há nenhum item quando o pedido é incluido pela primeira vez
		pedido.setValorBruto(valorInicial);
		pedido.setSituacao(SituacaoPedido.PROCESSANDO);
		pedidoDAO.save(pedido);
		return pedido;
	}
	
	public Pedido atualizarComItem(Item incluido) {
		Pedido pedido = pedidoDAO.findById(incluido.getPedido().getIdPedido());
		Date dataEntregaAtualizada = atualizarData(incluido,pedido);
		
		if(pedido.getDataEntrega() == null){
			pedido.setDataEntrega(dataEntregaAtualizada);
		}else{
			if(dataEntregaAtualizada.after(pedido.getDataEntrega())){
				pedido.setDataEntrega(dataEntregaAtualizada);
			}
		}	
		
		pedido.setValorBruto(obterValorBrutoAtual(incluido,pedido));
		
		BigDecimal valorDesconto = verificarDesconto(pedido, incluido);
		pedido.setValorDesconto(valorDesconto);
		pedido.setValorFinal(pedido.getValorBruto().subtract(valorDesconto));
		pedido = pedidoDAO.save(pedido);
		return pedido;
	}
	public BigDecimal obterValorBrutoAtual(Item item, Pedido pedido){
		BigDecimal valorBrutoAtual = pedido.getValorBruto();
		BigDecimal valorBrutoAtualizado = valorBrutoAtual.add(item.getValorTotal());
		return valorBrutoAtualizado;
	}
	
	public Long retornaUltimoID(){
		Pedido pedido = pedidoDAO.ultimo();
		return pedido.getIdPedido();
	}

	public boolean verificarSituacaoDosItens(Long idPedido) {
		Pedido pedido = pedidoDAO.findById(idPedido);
		for(Item item : pedido.getItens()){
			if(item.getSituacao()!=SituacaoItem.PROCESSADO){
				return false;
			}
		}
		return true;
	}

	public void atualizarSituacao(Long idPedido) {
		Pedido pedido = pedidoDAO.findById(idPedido);
		pedido.setSituacao(SituacaoPedido.PROCESSADO);
		pedidoDAO.save(pedido);
	}

	public void retirar(Long idPedido) {
		Pedido pedido = pedidoDAO.findById(idPedido);
		pedido.setSituacao(SituacaoPedido.ENCERRADO);
		pedidoDAO.save(pedido);
		
	}
}
