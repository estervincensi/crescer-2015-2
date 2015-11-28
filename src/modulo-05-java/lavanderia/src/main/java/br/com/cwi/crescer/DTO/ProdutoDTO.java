package br.com.cwi.crescer.DTO;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import br.com.cwi.crescer.domain.Produto;
import br.com.cwi.crescer.domain.Produto.SituacaoProduto;

public class ProdutoDTO {
	private Long idProduto;
	
	@NotNull
	private Long idServico;
	
	@NotNull
	private Long idMaterial;
	
	@NotNull
	private BigDecimal valor;
	
	private int prazo;
	
	private SituacaoProduto situacao;

	public int getPrazo() {
		return prazo;
	}

	public void setPrazo(int prazo) {
		this.prazo = prazo;
	}

	public SituacaoProduto getSituacao() {
		return situacao;
	}

	public void setSituacao(SituacaoProduto situacao) {
		this.situacao = situacao;
	}

	public ProdutoDTO(Produto produto) {
		this.idServico = produto.getServico().getIdServico();
		this.idProduto = produto.getIdProduto();
		this.idMaterial = produto.getMaterial().getIdMaterial();
		this.valor = produto.getValor();
		this.situacao = produto.getSituacao();
		this.prazo = produto.getPrazo();
	}

	public ProdutoDTO() {
	}

	public Long getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
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

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
}
