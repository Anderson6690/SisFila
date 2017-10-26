package com.developlus.sisfila.controller.pesquisa;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.developlus.sisfila.model.TipoAtendimentoPai;
import com.developlus.sisfila.service.TipoAtendimentoPaiService;

@Named
@RequestScoped
public class PesquisaTipoAtendimentoPaiBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private TipoAtendimentoPaiService tipoAtendimentoPaiService;

	private TipoAtendimentoPai tipoAtendimentoPai;
	private List<TipoAtendimentoPai> tiposAtendimentoPai;

	@PostConstruct
	public void init() {
		this.listar();
	}

	public void novo() {
		this.tipoAtendimentoPai = new TipoAtendimentoPai();
	}

	public void listar() {
		this.tiposAtendimentoPai = tipoAtendimentoPaiService.listar();
	}

	public TipoAtendimentoPai getTipoAtendimentoPai() {
		return tipoAtendimentoPai;
	}

	public void setTipoAtendimentoPai(TipoAtendimentoPai tipoAtendimentoPai) {
		this.tipoAtendimentoPai = tipoAtendimentoPai;
	}

	public List<TipoAtendimentoPai> getTiposAtendimentoPai() {
		return tiposAtendimentoPai;
	}

	public void setTiposAtendimentoPai(List<TipoAtendimentoPai> tiposAtendimentoPai) {
		this.tiposAtendimentoPai = tiposAtendimentoPai;
	}

	public boolean isTipoAtendimentoSelecionado() {
		return this.tipoAtendimentoPai != null;
	}

}
