package br.com.cwi.crescer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.cwi.crescer.jdbc.ConnectionFactory;
import br.com.cwi.crescer.model.Pedido;

public class PedidoDao {
	public void insert (Pedido pedido) throws SQLException{
		try(Connection conexao = new ConnectionFactory().getConnection()){
			PreparedStatement statement = conexao.prepareStatement("insert into pedido (idpedido, idcliente, dspedido) values (pedido_seq.nextval,?,?)");
			statement.setLong(1, pedido.getIdCliente());
			statement.setString(2, pedido.getDsPedido());
			statement.execute();
		}catch(SQLException e){
			throw e;
		}
	}
	public void update(Pedido pedido) throws SQLException{
		try(Connection conexao = new ConnectionFactory().getConnection()){
			PreparedStatement statement = conexao.prepareStatement("update pedido set idCliente = ?, dsPedido = ? where idPedido=?");
			statement.setLong(1, pedido.getIdCliente());
			statement.setString(2, pedido.getDsPedido());
			statement.setLong(3, pedido.getIdPedido());
			statement.execute();
		}catch(SQLException e){
			throw e;
		}
	}
	public List listarPedidosDeCliente(Long idCliente) throws SQLException{
		List <Pedido> lista = new ArrayList<Pedido>();
		try(Connection conexao = new ConnectionFactory().getConnection()){
			PreparedStatement statement = conexao.prepareStatement("select idPedido, idCliente, dsPedido from pedido where idcliente = ?");
			statement.setLong(1, idCliente);
			ResultSet resultset = statement.executeQuery();
			while(resultset.next()){
				Pedido pedido = new Pedido();
				pedido.setIdPedido(resultset.getLong("idPedido"));
				pedido.setIdCliente(resultset.getLong("idCliente"));
				pedido.setDsPedido(resultset.getString("dsPedido"));
				lista.add(pedido);
			}
			return lista;
		}catch (SQLException e){
			throw e;
		}
	}
	
	public Pedido findById(Long idPedido) throws SQLException{
		Pedido pedido = new Pedido();
		try(Connection conexao = new ConnectionFactory().getConnection()){
			PreparedStatement statement = conexao.prepareStatement("select idPedido, idCliente, dsPedido from pedido where idPedido = ?");
			statement.setLong(1, idPedido);
			ResultSet resultset = statement.executeQuery();
			if(resultset.next()){
				pedido.setIdPedido(resultset.getLong("idPedido"));
				pedido.setIdCliente(resultset.getLong("idCliente"));
				pedido.setDsPedido(resultset.getString("dsPedido"));
			}
		}catch(SQLException e){
			throw e;
		}
		return pedido;
	}
}
