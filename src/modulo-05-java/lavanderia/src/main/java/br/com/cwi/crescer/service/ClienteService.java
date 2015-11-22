package br.com.cwi.crescer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.crescer.DAO.ClienteDAO;

@Service
public class ClienteService {
private ClienteDAO clienteDAO;
	
	@Autowired
	public ClienteService(ClienteDAO clienteDAO){
		super();
		this.clienteDAO = clienteDAO;
	}
	
	public String buscarNome(Long id){
		return clienteDAO.findById(id).getNome();
	}

}
