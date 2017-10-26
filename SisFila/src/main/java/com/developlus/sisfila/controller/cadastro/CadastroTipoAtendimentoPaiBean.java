package com.developlus.sisfila.controller.cadastro;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.developlus.sisfila.model.TipoAtendimentoPai;
import com.developlus.sisfila.service.NegocioException;
import com.developlus.sisfila.service.TipoAtendimentoPaiService;
import com.developlus.sisfila.util.jsf.FacesUtil;

@Named
@RequestScoped
public class CadastroTipoAtendimentoPaiBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private TipoAtendimentoPaiService tipoAtendimentoPaiService;

	private TipoAtendimentoPai tipoAtendimentoPai;

	@PostConstruct
	public void init() {
		this.novo();
	}

	public void novo() {
		this.tipoAtendimentoPai = new TipoAtendimentoPai();
	}

	public void salvar() {
		try {
			this.tipoAtendimentoPaiService.salvar(tipoAtendimentoPai);
			FacesUtil.addSuccessMessage("Tipo de atendimento salvo com sucesso");

			this.novo();
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}

	}

	public TipoAtendimentoPai getTipoAtendimentoPai() {
		return tipoAtendimentoPai;
	}

	public void setTipoAtendimento(TipoAtendimentoPai tipoAtendimentoPai) {
		this.tipoAtendimentoPai = tipoAtendimentoPai;
	}

}
