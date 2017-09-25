package com.developlus.sisfila.controller.cadastro;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.developlus.sisfila.model.TipoSenha;
import com.developlus.sisfila.service.NegocioException;
import com.developlus.sisfila.service.TipoSenhaService;
import com.developlus.sisfila.util.jsf.FacesUtil;

@Named
@RequestScoped
public class CadastroTipoSenhaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private TipoSenhaService tipoSenhaService;

	private TipoSenha tipoSenha;

	@PostConstruct
	public void init() {
		this.novo();
	}

	public void novo() {
		this.tipoSenha = new TipoSenha();
	}

	public void salvar() {
		try {
			System.out.println(">>>> ID: " + tipoSenha.getId());
			this.tipoSenhaService.salvar(tipoSenha);
			FacesUtil.addSuccessMessage("Permissão salva com sucesso!");
			
			this.novo();
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}

	}

	public TipoSenha getTipoSenha() {
		return tipoSenha;
	}

	public void setTipoSenha(TipoSenha tipoSenha) {
		this.tipoSenha = tipoSenha;
	}

}
