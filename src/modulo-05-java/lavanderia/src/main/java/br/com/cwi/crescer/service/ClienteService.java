package br.com.cwi.crescer.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.crescer.DAO.CidadeDAO;
import br.com.cwi.crescer.DAO.ClienteDAO;
import br.com.cwi.crescer.DTO.ClienteDTO;
import br.com.cwi.crescer.DTO.ClienteResumoDTO;
import br.com.cwi.crescer.domain.Cliente;
import br.com.cwi.crescer.domain.Cliente.SituacaoCliente;
import br.com.cwi.crescer.mapper.ClienteMapper;

@Service
public class ClienteService {

	private ClienteDAO clienteDAO;
	private CidadeDAO cidadeDAO;

	@Autowired
	public ClienteService(ClienteDAO clienteDAO, CidadeDAO cidadeDAO) {
		this.clienteDAO = clienteDAO;
		this.cidadeDAO = cidadeDAO;
	}

	public List<ClienteResumoDTO> listarClientes() {
		List<Cliente> clientes = clienteDAO.listAll();
		List<ClienteResumoDTO> dtos = new ArrayList<ClienteResumoDTO>();
		for (Cliente cliente : clientes) {
			dtos.add(new ClienteResumoDTO(cliente));
		}
		return dtos;
	}
	
	public List<ClienteResumoDTO> listarClientesPorNome(String nome) {
		List<Cliente> clientes = clienteDAO.listByName(nome);
		List<ClienteResumoDTO> dtos = new ArrayList<ClienteResumoDTO>();
		for(Cliente cliente:clientes){
			dtos.add(new ClienteResumoDTO(cliente));
		}
		return dtos;
	}

	public ClienteDTO buscarClientePorId(Long id) {
		Cliente entity = clienteDAO.findById(id);
		return ClienteMapper.toDTO(entity);
	}

	public void atualizar(ClienteDTO dto) {
		Cliente entity = clienteDAO.findById(dto.getId());
		ClienteMapper.merge(dto, entity);
		entity.setSituacao(SituacaoCliente.valueOf(dto.getSituacao()));
		entity.setCidade(cidadeDAO.findById(dto.getIdCidade()));
		clienteDAO.save(entity);
	}

	public void incluir(ClienteDTO dto) {
		Cliente entity = ClienteMapper.getNewEntity(dto);
		entity.setCidade(cidadeDAO.findById(dto.getIdCidade()));
		entity.setSituacao(SituacaoCliente.ATIVO);
		clienteDAO.save(entity);
	}

	public void remover(ClienteDTO dto) {
		//clienteDAO.delete(dto.getId());
		Cliente entity = clienteDAO.findById(dto.getId());
		entity.setSituacao(SituacaoCliente.INATIVO);
		clienteDAO.save(entity);
	}



}
