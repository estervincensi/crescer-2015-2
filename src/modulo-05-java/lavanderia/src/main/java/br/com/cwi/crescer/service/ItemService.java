package br.com.cwi.crescer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.crescer.DAO.ItemDAO;
import br.com.cwi.crescer.domain.Item.SituacaoItem;

@Service
public class ItemService {
private ItemDAO itemDAO;
	
	@Autowired
	public ItemService(ItemDAO itemDAO){
		super();
		this.itemDAO = itemDAO;
	}
	
	public SituacaoItem buscarSituacao(Long id){
		return itemDAO.findById(id).getSituacao();
	}

}
