package br.com.fiap.aplicacao;
import java.util.Date;
import java.util.List;

import br.com.fiap.dao.ClientesDao;
import br.com.fiap.dao.PedidosDao;
import br.com.fiap.entity.Clientes;
import br.com.fiap.entity.Pedidos;
import br.com.fiap.factory.DaoFactory;

public class Main {

	public static void main(String[] args) throws Exception {

		ClientesDao clienteDao = DaoFactory.getDaoFactory().getClientesDao();
		PedidosDao pedidoDao = DaoFactory.getDaoFactory().getPedidosDao();
		
		
		Clientes c = new Clientes("Mateus Santos","mateus.artur@hotmail.com");
		Clientes c1 = new Clientes("George Santos","georgesantos@gmail.com");
		
		clienteDao.inserirCliente(c);
		clienteDao.inserirCliente(c1);
		
		
		
		Pedidos p = new Pedidos(c.getIdCliente(),new Date(),"Furadeira",750);
		Pedidos p1 = new Pedidos(c.getIdCliente(),new Date(),"Serra Tico-Tico",800);
		
		Pedidos p2 = new Pedidos(c1.getIdCliente(),new Date(),"Martelo",300);
		Pedidos p3 = new Pedidos(c1.getIdCliente(),new Date(),"100 - Pregos",30);
		pedidoDao.incluirPedido(p);
		pedidoDao.incluirPedido(p1);
		pedidoDao.incluirPedido(p2);
		pedidoDao.incluirPedido(p3);
		
		List<Pedidos>pedidosCliente1 = pedidoDao.listarPedidos(1);
		List<Pedidos>pedidosCliente2 = pedidoDao.listarPedidos(2);
		
		Clientes cliente1 = clienteDao.buscarCliente(1);

		Clientes cliente2 = clienteDao.buscarCliente(2);
		
		System.out.println("Nome : " + cliente1.getNome() + "\nEmail : " + cliente1.getEmail());
		System.out.println("Pedidos do Cliente "+ cliente1.getNome() + ": ");
		pedidosCliente1.forEach(System.out::println);
		System.out.println("Nome : " + cliente2.getNome() + "\nEmail : " + cliente2.getEmail());
		System.out.println("Pedidos do Cliente "+ cliente2.getNome() + ": ");
		pedidosCliente2.forEach(System.out::println);
	}

}