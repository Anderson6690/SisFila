package com.developlus.sisfila.controller;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import com.developlus.sisfila.model.Estado;
import com.developlus.sisfila.service.EstadoService;
import com.developlus.sisfila.service.NegocioException;
import com.developlus.sisfila.util.jsf.FacesUtil;

@Named
@RequestScoped
public class CadastroEstadoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EstadoService estadoService;

	private Estado estado;

	@PostConstruct
	public void init() {
		this.novo();
	}

	public void novo() {
		this.estado = new Estado();
	}

	public void salvar() {
		try {
			this.estadoService.salvar(estado);
			FacesUtil.addSuccessMessage("Estado salvo com sucesso!");

			this.novo();
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

}
