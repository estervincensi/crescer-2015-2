package br.com.cwi.crescer.mapper;

import br.com.cwi.crescer.DTO.ItemDTO;
import br.com.cwi.crescer.domain.Item;

public class ItemMapper {

	public static Item getNewEntity(ItemDTO itemDTO) {
		Item item = new Item();
		item.setPeso(itemDTO.getPeso());
		item.setSituacao(itemDTO.getSituacao());
		return item;
	}

}
