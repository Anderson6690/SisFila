package com.developlus.sisfila.controller.cadastro;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.developlus.sisfila.enums.Sexo;
import com.developlus.sisfila.model.Cliente;
import com.developlus.sisfila.service.ClienteService;
import com.developlus.sisfila.service.NegocioException;
import com.developlus.sisfila.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroClienteBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private ClienteService clienteService;

	private Cliente cliente;

	@PostConstruct
	private void init() {
		this.novo();
	}

	public void novo() {
		this.cliente = new Cliente();
	}

	public void salvar() {
		try {
			this.clienteService.salvar(cliente);
			FacesUtil.addSuccessMessage("Cliente salvo com sucesso!");

			this.novo();
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}
	}

	public Sexo[] getSexo() {
		return Sexo.values();
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}
