package br.com.cwi.crescer.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.crescer.DAO.MaterialDAO;
import br.com.cwi.crescer.DAO.ProdutoDAO;
import br.com.cwi.crescer.DAO.ServicoDAO;
import br.com.cwi.crescer.DTO.ProdutoDTO;
import br.com.cwi.crescer.domain.Produto;
import br.com.cwi.crescer.domain.Produto.SituacaoProduto;
import br.com.cwi.crescer.mapper.ProdutoMapper;

@Service
public class ProdutoService {
private ProdutoDAO produtoDAO;
private ServicoDAO servicoDAO;
private MaterialDAO materialDAO;
	
	@Autowired
	public ProdutoService(ProdutoDAO produtoDAO, MaterialDAO materialDAO, ServicoDAO servicoDAO){
		this.produtoDAO = produtoDAO;
		this.materialDAO = materialDAO;
		this.servicoDAO = servicoDAO;
	}

	public List<ProdutoDTO> listarProdutos() {
		List<Produto> produtos = produtoDAO.listAll();
		List<ProdutoDTO> dtos = new ArrayList<ProdutoDTO>();
		for(Produto produto:produtos){
			dtos.add(new ProdutoDTO(produto));
		}
		return dtos;
	}

	public boolean incluir(ProdutoDTO dto) {
		List<Produto> produto = produtoDAO.verificarSeExiste(dto.getIdServico(),dto.getIdMaterial());
		if(produto.isEmpty()){
			Produto entity = ProdutoMapper.getNewEntity(dto);
			entity.setMaterial(materialDAO.findById(dto.getIdMaterial()));
			entity.setServico(servicoDAO.findById(dto.getIdServico()));
			entity.setSituacao(SituacaoProduto.ATIVO);
			produtoDAO.save(entity);
			return true;
		}
		return false;
		
	}
	
}
