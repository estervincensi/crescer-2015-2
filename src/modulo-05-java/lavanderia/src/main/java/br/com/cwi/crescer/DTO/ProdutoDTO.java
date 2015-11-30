package br.com.cwi.crescer.DTO;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import br.com.cwi.crescer.domain.Material;
import br.com.cwi.crescer.domain.Produto;
import br.com.cwi.crescer.domain.Produto.SituacaoProduto;
import br.com.cwi.crescer.domain.Servico;

public class ProdutoDTO {
	private Long idProduto;
	
	@NotNull
	private Servico servico;
	
	@NotNull
	private Material material;
	
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
		this.servico = produto.getServico();
		this.idProduto = produto.getIdProduto();
		this.material = produto.getMaterial();
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

	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}

	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
}
