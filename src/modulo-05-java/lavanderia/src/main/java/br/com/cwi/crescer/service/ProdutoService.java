package br.com.cwi.crescer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.crescer.DAO.ProdutoDAO;

@Service
public class ProdutoService {
private ProdutoDAO produtoDAO;
	
	@Autowired
	public ProdutoService(ProdutoDAO produtoDAO){
		super();
		this.produtoDAO = produtoDAO;
	}
	
	public double buscarValor(Long id){
		return produtoDAO.findById(id).getValor();
	}
	
}
