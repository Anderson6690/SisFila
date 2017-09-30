package com.developlus.sisfila.controller.cadastro;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.developlus.sisfila.model.Grupo;
import com.developlus.sisfila.model.Permissao;
import com.developlus.sisfila.service.GrupoService;
import com.developlus.sisfila.service.NegocioException;
import com.developlus.sisfila.service.PermissaoService;
import com.developlus.sisfila.util.jsf.FacesUtil;

@Named
@RequestScoped
public class CadastroGrupoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private GrupoService grupoService;

	@Inject
	private PermissaoService permissaoService;

	private Grupo grupo = new Grupo();

	// @PostConstruct
	public void init() {
		this.novo();
	}

	public void novo() {
		this.grupo = new Grupo();
	}

	public void salvar() {
		try {
			System.out.println(">>>> ID: " + grupo.getId());
			this.grupoService.salvar(grupo);
			FacesUtil.addSuccessMessage("Permissão salva com sucesso!");

			this.novo();
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}

	}

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	public List<Permissao> getPermissoes() {
		return permissaoService.listar();
	}

}
