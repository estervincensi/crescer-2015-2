package br.com.cwi.crescer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.crescer.DAO.CidadeDAO;

@Service
public class CidadeService {
	private CidadeDAO cidadeDAO;
	
	@Autowired
	public CidadeService(CidadeDAO cidadeDAO){
		super();
		this.cidadeDAO = cidadeDAO;
	}
	
	public String buscarNome(Long id){
		return cidadeDAO.findById(id).getNome();
	}

}
