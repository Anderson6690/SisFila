package com.developlus.sisfila.controller.cadastro;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.developlus.sisfila.model.TipoAtendimento;
import com.developlus.sisfila.model.TipoAtendimentoPai;
import com.developlus.sisfila.service.NegocioException;
import com.developlus.sisfila.service.TipoAtendimentoPaiService;
import com.developlus.sisfila.service.TipoAtendimentoService;
import com.developlus.sisfila.util.jsf.FacesUtil;

@Named
@RequestScoped
public class CadastroTipoAtendimentoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private TipoAtendimentoService tipoAtendimentoService;

	@Inject
	private TipoAtendimentoPaiService tipoAtendimentoPaiService;

	private TipoAtendimento tipoAtendimento;

	@PostConstruct
	public void init() {
		this.novo();
	}

	public void novo() {
		this.tipoAtendimento = new TipoAtendimento();
	}

	public void salvar() {
		try {
			this.tipoAtendimentoService.salvar(tipoAtendimento);
			FacesUtil.addSuccessMessage("TipoAtendimento Salva com Sucesso");

			this.novo();
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}

	}

	public TipoAtendimento getTipoAtendimento() {
		return tipoAtendimento;
	}

	public void setTipoAtendimento(TipoAtendimento tipoAtendimento) {
		this.tipoAtendimento = tipoAtendimento;
	}

	public List<TipoAtendimentoPai> getTiposAtendimentoPai() {
		return tipoAtendimentoPaiService.listar();
	}

}
