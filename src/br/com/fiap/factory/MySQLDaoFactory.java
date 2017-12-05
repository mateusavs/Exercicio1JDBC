package br.com.fiap.factory;

import java.sql.Connection;
import java.sql.DriverManager;

import br.com.fiap.dao.ClientesDao;
import br.com.fiap.dao.MySQLClientesDao;
import br.com.fiap.dao.MySQLPedidosDao;
import br.com.fiap.dao.PedidosDao;

public class MySQLDaoFactory extends DaoFactory{
	public static final String DRIVER = "com.mysql.jdbc.Driver";
	public static final String URL = "jdbc:mysql://localhost:3306/persistencia_exe1";

	public static Connection criarConexao() throws Exception{ 
		return DriverManager.getConnection(URL,"root","140697");
	}

	@Override
	public ClientesDao getClientesDao() {
		return new MySQLClientesDao();
	}

	@Override
	public PedidosDao getPedidosDao() {
		return new MySQLPedidosDao();
	}
}