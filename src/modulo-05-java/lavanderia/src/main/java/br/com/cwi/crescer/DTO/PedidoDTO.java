package br.com.cwi.crescer.DTO;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import br.com.cwi.crescer.domain.Cliente;
import br.com.cwi.crescer.domain.Item;
import br.com.cwi.crescer.domain.Pedido;
import br.com.cwi.crescer.domain.Pedido.SituacaoPedido;

public class PedidoDTO {
	private Long idPedido;
	private Cliente cliente;
	private Date dataInclusao;
	private Date dataEntrega;
	private BigDecimal valorBruto;
	private BigDecimal valorDesconto;
	private BigDecimal valorFinal;
	private SituacaoPedido situacao;
	private List<Item> itens;
	
	public PedidoDTO(Pedido pedido) {
		this.idPedido = pedido.getIdPedido();
		this.cliente = pedido.getCliente();
		this.dataInclusao = pedido.getDataInclusao();
		this.dataEntrega = pedido.getDataEntrega();
		this.valorBruto = pedido.getValorBruto();
		this.situacao = pedido.getSituacao();
		this.itens=pedido.getItens();
	}
	public PedidoDTO() {
		// TODO Auto-generated constructor stub
	}
	
	
	public List<Item> getItens() {
		return itens;
	}
	public void setItens(List<Item> itens) {
		this.itens = itens;
	}
	public Long getIdPedido() {
		return idPedido;
	}
	public void setIdPedido(Long idPedido) {
		this.idPedido = idPedido;
	}

	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Date getDataInclusao() {
		return dataInclusao;
	}
	public void setDataInclusao(Date dataInclusao) {
		this.dataInclusao = dataInclusao;
	}
	public Date getDataEntrega() {
		return dataEntrega;
	}
	public void setDataEntrega(Date dataEntrega) {
		this.dataEntrega = dataEntrega;
	}
	public SituacaoPedido getSituacao() {
		return situacao;
	}
	public void setSituacao(SituacaoPedido situacao) {
		this.situacao = situacao;
	}
	
	public BigDecimal getValorBruto() {
		return valorBruto;
	}
	public void setValorBruto(BigDecimal valorBruto) {
		this.valorBruto = valorBruto;
	}
	public BigDecimal getValorDesconto() {
		return valorDesconto;
	}
	public void setValorDesconto(BigDecimal valorDesconto) {
		this.valorDesconto = valorDesconto;
	}
	public BigDecimal getValorFinal() {
		return valorFinal;
	}
	public void setValorFinal(BigDecimal valorFinal) {
		this.valorFinal = valorFinal;
	}
	
}
