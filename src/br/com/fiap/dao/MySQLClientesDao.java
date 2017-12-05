package br.com.fiap.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.jdbc.Statement;

import br.com.fiap.entity.Clientes;
import br.com.fiap.factory.MySQLDaoFactory;

public class MySQLClientesDao implements ClientesDao{
	Clientes cliente = null;
	ResultSet rs;
	PreparedStatement stmt;
	Connection cn = null;

	@Override
	public Clientes inserirCliente(Clientes cliente) throws Exception{
		try {
			cn = MySQLDaoFactory.criarConexao();
			stmt = cn.prepareStatement("INSERT INTO CLIENTES (NOME, EMAIL) VALUES (?,?)", Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, cliente.getNome()); 
			stmt.setString(2, cliente.getEmail());
			stmt.executeUpdate();

			rs = stmt.getGeneratedKeys();
			while (rs.next()){
				cliente.setIdCliente(rs.getInt(1));
			}
		} catch (Exception e) { 
			e.printStackTrace();
		} finally { 
			cn.close();
			if (stmt != null) 
				stmt.close();
			if (rs != null)
				rs.close();
		} 
		return cliente;
	}

	@Override
	public Clientes buscarCliente(int idCliente) throws Exception{ 
		try {
			cn = MySQLDaoFactory.criarConexao();
			stmt = cn.prepareStatement("SELECT * FROM CLIENTES WHERE IDCLIENTE=?");
			stmt.setInt(1, idCliente);
			rs = stmt.executeQuery();
			
			if (rs.next()) {
				cliente = new Clientes(rs.getInt("IDCLIENTE"), rs.getString("NOME"), rs.getString("EMAIL"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			cn.close();
			if (stmt != null)
				stmt.close();
			if (rs != null)
				rs.close();
		}

		return cliente;

	}

} 
