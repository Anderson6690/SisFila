package com.developlus.sisfila.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.developlus.sisfila.model.Grupo;
import com.developlus.sisfila.repository.GrupoRepository;
import com.developlus.sisfila.util.cdi.CDIServiceLocator;

@FacesConverter(forClass = Grupo.class)
public class GrupoConverter implements Converter {

	private GrupoRepository grupoRepository;

	public GrupoConverter() {
		this.grupoRepository = CDIServiceLocator.getBean(GrupoRepository.class);
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Grupo retorno = null;

		if (value != null) {
			retorno = this.grupoRepository.findOne(new Long(value));
		}

		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Grupo grupo = (Grupo) value;

			return grupo.getId() == null ? null : grupo.getId().toString();
		}

		return "";
	}

}