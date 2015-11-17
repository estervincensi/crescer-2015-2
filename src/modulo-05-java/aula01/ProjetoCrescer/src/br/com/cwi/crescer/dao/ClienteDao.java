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
			PreparedStatement statement = conexao.prepareStatement("insert into cliente (idCliente, nmCliente, nrCpf) values (?,?,?)");
			statement.setLong(1, cliente.getIdCliente());
			statement.setString(2, cliente.getNmCliente());
			statement.setString(3, cliente.getCpfCliente());
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
}
