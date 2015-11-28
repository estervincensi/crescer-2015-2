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

	public ProdutoDTO buscarProdutoPorId(Long id) {
		Produto entity = produtoDAO.findById(id);
		return ProdutoMapper.toDTO(entity);
	}

	public void atualizar(ProdutoDTO dto) {
		Produto entity = produtoDAO.findById(dto.getIdProduto());
		ProdutoMapper.merge(dto, entity);
		produtoDAO.save(entity);
		
	}

	public List<ProdutoDTO> listarProdutosPorMaterialeServico(String material, String servico) {
		List<Produto>produtos = produtoDAO.listarPorMaterialEServico(material,servico);
		List<ProdutoDTO> dtos = new ArrayList<ProdutoDTO>();
		for(Produto produto: produtos){
			dtos.add(new ProdutoDTO(produto));
		}
		return dtos;
	}

	public List<ProdutoDTO> listarProdutosPorMaterial(String material) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<ProdutoDTO> listarProdutosPorServico(String servico) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
