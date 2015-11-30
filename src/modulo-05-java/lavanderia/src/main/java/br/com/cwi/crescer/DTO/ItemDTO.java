package br.com.cwi.crescer.DTO;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import br.com.cwi.crescer.domain.Item.SituacaoItem;

public class ItemDTO {

	private Long idItem;
	
	@NotNull
	private Long idPedido;
	
	@NotNull
	private Long idServico;
	
	@NotNull
	private Long idMaterial;
	
	@NotNull
	private BigDecimal peso;
	
	
	private SituacaoItem situacao;
	public Long getIdItem() {
		return idItem;
	}
	public void setIdItem(Long idItem) {
		this.idItem = idItem;
	}
	public Long getIdPedido() {
		return idPedido;
	}
	public void setIdPedido(Long idPedido) {
		this.idPedido = idPedido;
	}
	public BigDecimal getPeso() {
		return peso;
	}
	public void setPeso(BigDecimal peso) {
		this.peso = peso;
	}
	public SituacaoItem getSituacao() {
		return situacao;
	}
	public void setSituacao(SituacaoItem situacao) {
		this.situacao = situacao;
	}
	public Long getIdServico() {
		return idServico;
	}
	public void setIdServico(Long idServico) {
		this.idServico = idServico;
	}
	public Long getIdMaterial() {
		return idMaterial;
	}
	public void setIdMaterial(Long idMaterial) {
		this.idMaterial = idMaterial;
	}
	
	
}
