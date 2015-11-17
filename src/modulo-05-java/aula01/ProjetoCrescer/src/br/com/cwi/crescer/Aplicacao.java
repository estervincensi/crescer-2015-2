package br.com.cwi.crescer;

import java.sql.SQLException;
import java.util.List;

import br.com.cwi.crescer.dao.ClienteDao;
import br.com.cwi.crescer.model.Cliente;
import br.com.cwi.crescer.model.Servico;

public class Aplicacao {

    public static void main(String[] args) throws SQLException{
    	//DIA 02
    	Cliente cliente = new Cliente();
    	cliente.setIdCliente(1L);
    	cliente.setNmCliente("Ester");
    	cliente.setCpfCliente("12345");
    	ClienteDao clienteDao = new ClienteDao();
    	//clienteDao.insert(cliente);
    	
    	List<Cliente> lista = clienteDao.listAll();
    	
    	for (Cliente cliente2 : lista) {
    		System.out.println(cliente2.getIdCliente());
			System.out.println(cliente2.getNmCliente());
			System.out.println(cliente2.getCpfCliente());
		}
    	
        //DIA 01
    	/*Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        StringBuilder menuInterior = new StringBuilder();
        LinkedListsInterface<String> list = new LinkedList<String>();
        int opcaoGeral=0, opcaoInterior=0;
        sb.append("Digite uma opção:\n");
        sb.append("1 - Trabalhar com Listas Encadeadas\n");
        sb.append("2 - Trabalhar com Listas Duplamente Encadeadas\n");
        sb.append("3 - Sair");
		menuInterior.append("1 - Adicionar no inicio\n");
		menuInterior.append("2 - Adicionar no meio\n");
		menuInterior.append("3 - Adicionar no fim\n");
		menuInterior.append("4 - Remover do inicio\n");
		menuInterior.append("5 - Remover do meio\n");
		menuInterior.append("6 - Mostrar Todos\n");
		menuInterior.append("8 - Voltar\n");
        while(opcaoGeral!=3){
        	System.out.println(sb);
        	opcaoGeral = scanner.nextInt();
        	if(opcaoGeral==1){
        		list = new LinkedList<String>();
        	}else if(opcaoGeral==2){
        		list = new DoublyLinkedList<String>();
        	}
        	while(opcaoInterior!=8){
        		System.out.println(menuInterior);
        		opcaoInterior = scanner.nextInt();
        		if(opcaoInterior==1){
        			System.out.println("Digite o valor (string)");
        			scanner.nextLine();
        			String valor = scanner.nextLine();
        			list.addFirst(valor);
        		}else if(opcaoInterior==2){
        			System.out.println("Digite o valor (string)");
        			scanner.nextLine();
        			String valor = scanner.nextLine();
        			System.out.println("Digite a posição:");
        			int posicao = scanner.nextInt();
        			list.add(posicao, valor);
        		}else if(opcaoInterior==3){
        			System.out.println("Digite o valor (string)");
        			scanner.nextLine();
        			String valor = scanner.nextLine();
        			list.addLast(valor);
        		}else if(opcaoInterior==4){
        			list.removeFirst();
        			System.out.println("Removido com sucesso!");
        		}else if(opcaoInterior==5){
        			System.out.println("Digite a posição: ");
        			int posicao = scanner.nextInt();
        			list.remove(posicao);
        		}else if(opcaoInterior==6){
        			System.out.println(list.list());
        		}
        	}
        } 
    	//Aula 02
    	
    	/*File file = new File("c:\\temp\\crescer.txt");
    	if(file.isDirectory()){
    		//mostra o arquivo
    		File files[]= file.listFiles();
    		for (int i = 0; i < files.length; i++) {
				System.out.println(files[i].getName());
			}
    	}
    	//verifica se arquivo ja existe
    	System.out.println(file.exists());
    	//altera data de modificação
    	file.setLastModified(new Date().getTime()-(24*60*60*1000));
    	file.createNewFile();*/
    }
}
