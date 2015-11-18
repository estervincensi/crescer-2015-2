package br.com.cwi.crescer;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import br.com.cwi.crescer.dao.ClienteDao;
import br.com.cwi.crescer.dao.PedidoDao;
import br.com.cwi.crescer.model.Cliente;
import br.com.cwi.crescer.model.Pedido;

public class Aplicacao {
    public static void main(String[] args) throws SQLException{
		Scanner scanner = new Scanner(System.in);
    	ClienteDao clienteDao = new ClienteDao();
    	Cliente cliente = new Cliente();
    	PedidoDao pedidoDao = new PedidoDao();
    	Pedido pedido = new Pedido();
    	int opcao;
    	
    	do{
    		System.out.println("Digite uma opcao:");
        	System.out.println("1 - Inserir Cliente");
        	System.out.println("2 - Inserir Pedido");
        	System.out.println("3 - Listar pedidos por cliente");
        	System.out.println("4 - Buscar pedido");
        	System.out.println("5 - Sair");
        	opcao = scanner.nextInt();
        	
        	switch(opcao){
        		case 1: 
        			System.out.println("Digite o nome do cliente: ");
        			scanner.nextLine();
        			String nome = scanner.nextLine();
        			System.out.println("Digite o cpf do cliente: ");
        			String cpf = scanner.nextLine();
        			cliente.setNmCliente(nome);
        			cliente.setCpfCliente(cpf);
        			clienteDao.insert(cliente);
        			break;
        		case 2:
        			Long id = procuraId();
        			pedido.setIdCliente(id);
        			System.out.println("Digite a descricao do pedido: ");
        			scanner.nextLine();
        			String descricaoPedido = scanner.nextLine();
        			pedido.setDsPedido(descricaoPedido);
        			pedidoDao.insert(pedido);
        			System.out.println("Pedido incluído com sucesso!");
        			break;
        		case 3:
        			id = procuraId();
        			List<Pedido> listaPedidos = pedidoDao.listarPedidosDeCliente(id);
        			for(Pedido pedidos:listaPedidos){
        				System.out.println("ID: "+pedidos.getIdPedido());
        				System.out.println("Descrição: "+pedidos.getDsPedido());
        			}
        			
        		case 4:
        			System.out.println("Digite o numero do pedido:");
        			Long idPedido = scanner.nextLong();
        			pedido = pedidoDao.findById(idPedido);
        			System.out.println("Descrição: "+pedido.getDsPedido());
        		default: System.out.println("Opção Inválida!");
        			
        	}
    	}while(opcao!=5);
    }
    public static Long procuraId() throws SQLException{
    	Scanner scanner = new Scanner(System.in);
    	Cliente cliente = new Cliente();
    	ClienteDao clienteDao = new ClienteDao();
    	System.out.println("Digite o nome do Cliente: ");
		scanner.nextLine();
		String nomeCliente = scanner.nextLine();
		cliente.setNmCliente(nomeCliente);
		List<Cliente>listaCliente = clienteDao.find(cliente);
		for(Cliente clientes:listaCliente){
			System.out.println("Id: "+clientes.getIdCliente());
			System.out.println("Nome: "+clientes.getNmCliente());
			System.out.println("CPF: "+clientes.getCpfCliente());
		}
		System.out.println("Escolha qual dos clientes: (id)");
		Long id = scanner.nextLong();
		return id;
    }
}

//DIA 03
/*Cliente cliente = new Cliente();
cliente.setNmCliente("Ester");
cliente.setCpfCliente("12345");
ClienteDao clienteDao = new ClienteDao();
//clienteDao.insert(cliente);

List<Cliente> lista = clienteDao.listAll();

//System.out.println("mostrar todos");
//for (Cliente cliente2 : lista) {
	//System.out.println(cliente2.getIdCliente());
	//System.out.println(cliente2.getNmCliente());
	//System.out.println(cliente2.getCpfCliente());
//}
//clienteDao.delete(1L);

cliente.setNmCliente("alterado");
cliente.setCpfCliente("1234567");
//clienteDao.update(cliente);

System.out.println("buscar ");
Cliente find = new Cliente();
find.setNmCliente("Ester");
//find.setCpfCliente("1234567");
//find.setIdCliente(1L);
List<Cliente>listafind = clienteDao.find(find);
for(Cliente listado:listafind){
	System.out.println(listado.getIdCliente());
	System.out.println(listado.getNmCliente());
	System.out.println(listado.getCpfCliente());
}*/