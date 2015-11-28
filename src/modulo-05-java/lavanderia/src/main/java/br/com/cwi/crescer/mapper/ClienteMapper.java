package br.com.cwi.crescer.mapper;



import br.com.cwi.crescer.DTO.ClienteDTO;
import br.com.cwi.crescer.domain.Cliente;
import br.com.cwi.crescer.domain.Cliente.SituacaoCliente;

public class ClienteMapper {

	public static Cliente getNewEntity(ClienteDTO dto) {
		Cliente entity = new Cliente();
		entity.setNome(dto.getNome());
		entity.setCpf(dto.getCpf());
		entity.setEmail(dto.getEmail());
		entity.setEndereco(dto.getEndereco());
		entity.setBairro(dto.getBairro());
		entity.setCep(dto.getCep());
		return entity;
	}

	public static ClienteDTO toDTO(Cliente entity) {
		ClienteDTO dto = new ClienteDTO();
		dto.setId(entity.getIdCliente());
		dto.setNome(entity.getNome());
		dto.setCpf(entity.getCpf());
		dto.setEmail(entity.getEmail());
		dto.setIdCidade(entity.getCidade().getIdCidade());
		dto.setEndereco(entity.getEndereco());
		dto.setBairro(entity.getBairro());
		dto.setCep(entity.getCep());
		dto.setSituacao(entity.getSituacao().toString());
		return dto;
	}

	public static Cliente merge(ClienteDTO dto, Cliente entity) {
		entity.setNome(dto.getNome());
		entity.setCpf(dto.getCpf());
		entity.setEmail(dto.getEmail());
		entity.setEndereco(dto.getEndereco());
		entity.setBairro(dto.getBairro());
		entity.setCep(dto.getCep());
		entity.setSituacao(SituacaoCliente.valueOf(dto.getSituacao()));

		return entity;
	}

}
