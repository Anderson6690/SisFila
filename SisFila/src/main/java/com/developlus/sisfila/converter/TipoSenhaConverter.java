package com.developlus.sisfila.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.developlus.sisfila.model.TipoSenha;
import com.developlus.sisfila.repository.TipoSenhaRepository;
import com.developlus.sisfila.util.cdi.CDIServiceLocator;

@FacesConverter(value = "tipoSenhaConverter", forClass = TipoSenha.class)
public class TipoSenhaConverter implements Converter {

	private TipoSenhaRepository tipoSenhaRepository;

	public TipoSenhaConverter() {
		this.tipoSenhaRepository = CDIServiceLocator.getBean(TipoSenhaRepository.class);
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		TipoSenha retorno = null;

		if (value != null) {
			retorno = this.tipoSenhaRepository.findOne(new Long(value));
		}

		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {

		if (value != null) {
			TipoSenha tipoSenha = (TipoSenha) value;

			return tipoSenha.getId() == null ? null : tipoSenha.getId().toString();
		}

		return "";
	}

}