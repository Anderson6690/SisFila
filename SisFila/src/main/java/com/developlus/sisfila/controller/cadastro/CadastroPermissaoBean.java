package com.developlus.sisfila.controller.cadastro;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.developlus.sisfila.model.Permissao;
import com.developlus.sisfila.service.NegocioException;
import com.developlus.sisfila.service.PermissaoService;
import com.developlus.sisfila.util.jsf.FacesUtil;

@Named
@RequestScoped
public class CadastroPermissaoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private PermissaoService permissaoService;

	private Permissao permissao;

	@PostConstruct
	public void init() {
		this.novo();
	}

	public void novo() {
		this.permissao = new Permissao();
	}

	public void salvar() {
		try {
			System.out.println(">>>> ID: " + permissao.getId());
			this.permissaoService.salvar(permissao);
			FacesUtil.addSuccessMessage("Permissão salva com sucesso!");
			
			this.novo();
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}

	}

	public Permissao getPermissao() {
		return permissao;
	}

	public void setPermissao(Permissao permissao) {
		this.permissao = permissao;
	}

}
