package com.developlus.sisfila.controller.pesquisa;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.developlus.sisfila.model.TipoAtendimento;
import com.developlus.sisfila.service.TipoAtendimentoService;

@Named
@RequestScoped
public class PesquisaTipoAtendimentoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private TipoAtendimentoService tipoAtendimentoService;

	private TipoAtendimento tipoAtendimento;
	private List<TipoAtendimento> tiposAtendimento;

	@PostConstruct
	public void init() {
		this.listar();
	}

	public void novo() {
		this.tipoAtendimento = new TipoAtendimento();
	}

	public void listar() {
		this.tiposAtendimento = tipoAtendimentoService.listar();
	}

	public TipoAtendimento getTipoAtendimento() {
		return tipoAtendimento;
	}

	public void setTipoAtendimento(TipoAtendimento tipoAtendimento) {
		this.tipoAtendimento = tipoAtendimento;
	}

	public List<TipoAtendimento> getTiposAtendimento() {
		return tiposAtendimento;
	}

	public void setTiposAtendimento(List<TipoAtendimento> tiposAtendimento) {
		this.tiposAtendimento = tiposAtendimento;
	}

	public boolean isTipoAtendimentoSelecionado() {
		return this.tipoAtendimento != null;
	}

}
