package br.com.cwi.crescer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.crescer.DAO.MaterialDAO;

@Service
public class MaterialService {
private MaterialDAO materialDAO;
	
	@Autowired
	public MaterialService(MaterialDAO materialDAO){
		super();
		this.materialDAO = materialDAO;
	}
	
	public String buscarDescricao(Long id){
		return materialDAO.findById(id).getDescricao();
	}

}
