package com.developlus.sisfila.controller.pesquisa;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.developlus.sisfila.model.Empresa;
import com.developlus.sisfila.service.EmpresaService;

@Named
@ViewScoped
public class PesquisaEmpresaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EmpresaService empresaService;

	private Empresa empresa;
	private List<Empresa> empresas;

	@PostConstruct
	private void init() {
		this.listar();
	}

	public void novo() {
		this.empresa = new Empresa();
	}

	public void listar() {
		this.empresas = empresaService.listar();
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public List<Empresa> getEmpresas() {
		return empresas;
	}
	
	public boolean isEmpresaSelecionado() {
		return this.empresa != null;
	}

}
