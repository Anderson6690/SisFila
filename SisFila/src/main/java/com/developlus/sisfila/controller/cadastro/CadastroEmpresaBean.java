package com.developlus.sisfila.controller.cadastro;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.developlus.sisfila.model.Cidade;
import com.developlus.sisfila.model.Empresa;
import com.developlus.sisfila.service.CidadeService;
import com.developlus.sisfila.service.EmpresaService;
import com.developlus.sisfila.service.NegocioException;
import com.developlus.sisfila.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroEmpresaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EmpresaService empresaService;

	@Inject
	private CidadeService cidadeService;

	private Empresa empresa;

	@PostConstruct
	private void init() {
		this.novo();
	}

	public void novo() {
		this.empresa = new Empresa();
	}

	public void salvar() {
		try {
			this.empresaService.salvar(empresa);
			FacesUtil.addSuccessMessage("Empresa salvo com sucesso!");

			this.novo();
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public List<Cidade> getCidades() {
		return cidadeService.listar();
	}
}
