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

}
