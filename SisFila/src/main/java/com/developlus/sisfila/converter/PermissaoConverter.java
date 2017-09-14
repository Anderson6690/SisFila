package com.developlus.sisfila.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.developlus.sisfila.model.Permissao;
import com.developlus.sisfila.repository.PermissaoRepository;
import com.developlus.sisfila.util.cdi.CDIServiceLocator;

@FacesConverter(value = "permissaoConverter", forClass = Permissao.class)
public class PermissaoConverter implements Converter {

	private PermissaoRepository permissaoRepository;

	public PermissaoConverter() {
		this.permissaoRepository = CDIServiceLocator.getBean(PermissaoRepository.class);
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Permissao retorno = null;

		if (value != null) {
			retorno = this.permissaoRepository.findOne(new Long(value));
		}

		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		
		if (value != null) {
			Permissao permissao = (Permissao) value;

			return permissao.getId() == null ? null : permissao.getId().toString();
		}

		return "";
	}

}