package com.developlus.sisfila.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import com.developlus.sisfila.model.Cidade;
import com.developlus.sisfila.repository.CidadeRepository;
import com.developlus.sisfila.util.cdi.CDIServiceLocator;

@FacesConverter(forClass = Cidade.class)
public class CidadeConverter implements Converter {

	private CidadeRepository cidadeRepository;

	public CidadeConverter() {
		this.cidadeRepository = CDIServiceLocator.getBean(CidadeRepository.class);
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Cidade retorno = null;

		if (value != null) {
			retorno = this.cidadeRepository.findOne(new Long(value));
		}

		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {

		if (value != null) {
			Cidade cidade = (Cidade) value;

			return cidade.getId() == null ? null : cidade.getId().toString();
		}

		return "";
	}

}
