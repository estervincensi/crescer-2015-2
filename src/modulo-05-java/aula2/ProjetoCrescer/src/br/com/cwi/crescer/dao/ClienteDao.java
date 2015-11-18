package br.com.cwi.crescer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.cwi.crescer.jdbc.ConnectionFactory;
import br.com.cwi.crescer.model.Cliente;

public class ClienteDao {
	public void insert(Cliente cliente) throws SQLException{
		try(Connection conexao = new ConnectionFactory().getConnection()){
			PreparedStatement statement = conexao.prepareStatement("insert into cliente (idCliente, nmCliente, nrCpf) values (cliente_seq.nextval,?,?)");
			statement.setString(1, cliente.getNmCliente());
			statement.setString(2, cliente.getCpfCliente());
			statement.execute();
			
			//ou
			/*Statement stmt = conexao.createStatement();
			stmt.execute("insert into cliente (idCliente, nmCliente, nrCpf) values ("+cliente.getIdCliente()+",'"+cliente.getNmCliente()+"','"+cliente.getCpfCliente()+"')");
			stmt.close();*/
		}catch(SQLException e){
			throw e;
		}
	}
	public List<Cliente> listAll() throws SQLException{
		List<Cliente> lista = new ArrayList<Cliente>();
		try(Connection conexao = new ConnectionFactory().getConnection()){
			PreparedStatement statement = conexao.prepareStatement("Select idCliente, nmCliente, nrCpf from cliente");
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()){
				Cliente cliente = new Cliente();
				cliente.setIdCliente(resultSet.getLong("idCliente"));
				cliente.setNmCliente(resultSet.getString("nmCliente"));
				cliente.setCpfCliente(resultSet.getString("nrCpf"));
				lista.add(cliente);
			}
		}catch(SQLException e){
			throw e;
		}
		return lista;
	}
	public void delete(Long idCliente) throws SQLException {
		try(Connection conexao = new ConnectionFactory().getConnection()){
			PreparedStatement statement = conexao.prepareStatement("delete from cliente where idCliente = ?");
			statement.setLong(1, idCliente);
			statement.execute();
		}catch(SQLException e){
			throw e;
		}
		
	}
	public Cliente load(Long idCliente) throws SQLException{
		try(Connection conexao = new ConnectionFactory().getConnection()){
			Cliente cliente = new Cliente();
			
			PreparedStatement statement = conexao.prepareStatement("select idcliente, nmcliente, nrcpf from cliente where idcliente = ?");
			statement.setLong(1, idCliente);
			ResultSet resultSet = statement.executeQuery();
			if(resultSet.next()){
				cliente.setIdCliente(resultSet.getLong("idCliente"));
				cliente.setNmCliente(resultSet.getString("nmCliente"));
				cliente.setCpfCliente(resultSet.getString("nrCpf"));
			}else{
				throw new RuntimeException("Registro não encontrado!");
			}
			return cliente;
		}catch(SQLException e){
			throw e;
		}
	}
	public void update(Cliente cliente) throws SQLException{
		try(Connection conexao = new ConnectionFactory().getConnection()){
			
			PreparedStatement statement = conexao.prepareStatement("update cliente set nmCliente = ?, nrCpf=? where idcliente=?");
			statement.setString(1,cliente.getNmCliente());
			statement.setString(2, cliente.getCpfCliente());
			statement.setLong(3, cliente.getIdCliente());
			statement.execute();
		}catch (SQLException e){
			throw e;
		}
	}
	public List<Cliente> find(Cliente cliente) throws SQLException{
		List<Cliente> lista = new ArrayList<Cliente>();
		try(Connection conexao = new ConnectionFactory().getConnection()){
			StringBuilder query = new StringBuilder();
			query.append("select idcliente, nmcliente, nrcpf from cliente where 1=1");
			List<Object> parameters = new ArrayList<Object>();
			
			if(cliente.getIdCliente()!=null){
				query.append("and idcliente = ?");
				parameters.add(cliente.getIdCliente());
			}
			if(cliente.getNmCliente()!=null){
				query.append("and nmcliente = ?");
				parameters.add(cliente.getNmCliente());
			}
			if(cliente.getCpfCliente()!=null){
				query.append("and nrcpf = ?");
				parameters.add(cliente.getCpfCliente());
			}
			PreparedStatement statement= conexao.prepareStatement(query.toString());
			for(int i=0; i<parameters.size();i++){
				statement.setObject(i+1, parameters.get(i));
			}
			
			ResultSet resultset = statement.executeQuery();
			while(resultset.next()){
				Cliente listado = new Cliente();
				listado.setIdCliente(resultset.getLong("idCliente"));
				listado.setCpfCliente(resultset.getString("nrCpf"));
				listado.setNmCliente(resultset.getString("nmCliente"));
				lista.add(listado);
			}
			
		}catch(SQLException e){
			throw e;
		}
		return lista;
	}
}
