package com.developlus.sisfila.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.developlus.sisfila.model.Cliente;
import com.developlus.sisfila.service.ClienteService;

@Named
@ViewScoped
public class PesquisaClienteBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private ClienteService clienteService;

	private Cliente cliente;
	private List<Cliente> clientes;

	@PostConstruct
	private void init() {
		this.listar();
	}

	public void novo() {
		this.cliente = new Cliente();
	}

	public void listar() {
		this.clientes = clienteService.listar();
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
	
	public boolean isClienteSelecionado() {
		return this.cliente != null;
	}

}
