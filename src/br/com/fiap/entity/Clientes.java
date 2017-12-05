package br.com.fiap.entity;

public class Clientes {

	private int idCliente;
	private String nome;
	private String email;

	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Clientes(int idCliente, String nome, String email) {
		super();
		this.idCliente = idCliente;
		this.nome = nome;
		this.email = email;
	}
	public Clientes(String nome, String email) {
		super();
		this.nome = nome;
		this.email = email;
	}
	public Clientes(){
		super();
	}
}