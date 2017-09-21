package com.developlus.sisfila.controller.pesquisa;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import com.developlus.sisfila.model.Permissao;
import com.developlus.sisfila.service.PermissaoService;

@Named
@RequestScoped
public class PesquisaPermissaoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private PermissaoService permissaoService;

	private Permissao permissao;
	private List<Permissao> permissoes;

	@PostConstruct
	public void init() {
		this.listar();
	}

	public void listar() {
		this.permissoes = permissaoService.listar();
	}

	public Permissao getPermissao() {
		return permissao;
	}

	public void setPermissao(Permissao permissao) {
		this.permissao = permissao;
	}

	public List<Permissao> getPermissoes() {
		return permissoes;
	}

	public boolean isPermissaoSelecionada() {
		return this.permissao != null;
	}

}
