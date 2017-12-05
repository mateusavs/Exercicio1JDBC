package br.com.fiap.factory;

import br.com.fiap.dao.ClientesDao;
import br.com.fiap.dao.PedidosDao;


public abstract class DaoFactory {

	public abstract ClientesDao getClientesDao(); 
	public abstract PedidosDao getPedidosDao();

	public static DaoFactory getDaoFactory(){
		return new MySQLDaoFactory();
	} 
}