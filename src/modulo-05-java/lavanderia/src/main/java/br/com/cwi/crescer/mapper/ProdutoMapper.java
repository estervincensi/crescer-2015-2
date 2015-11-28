package br.com.cwi.crescer.mapper;

import br.com.cwi.crescer.DTO.ProdutoDTO;
import br.com.cwi.crescer.domain.Produto;

public class ProdutoMapper {

	public static Produto getNewEntity(ProdutoDTO dto) {
		Produto entity = new Produto();
		entity.setPrazo(dto.getPrazo());
		entity.setValor(dto.getValor());
		return entity;
	}

	public static ProdutoDTO toDTO(Produto entity) {
		ProdutoDTO dto = new ProdutoDTO();
		dto.setIdProduto(entity.getIdProduto());
		dto.setIdMaterial(entity.getMaterial().getIdMaterial());
		dto.setIdServico(entity.getServico().getIdServico());
		dto.setPrazo(entity.getPrazo());
		dto.setValor(entity.getValor());
		dto.setSituacao(entity.getSituacao());
		return dto;
	}
	
	public static Produto merge(ProdutoDTO dto, Produto entity) {
		entity.setPrazo(dto.getPrazo());
		entity.setValor(dto.getValor());
		entity.setSituacao(dto.getSituacao());
		return entity;
	}

}
