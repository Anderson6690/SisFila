package com.developlus.sisfila.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.developlus.sisfila.model.TipoAtendimentoPai;
import com.developlus.sisfila.repository.TipoAtendimentoPaiRepository;
import com.developlus.sisfila.util.cdi.CDIServiceLocator;

@FacesConverter(forClass = TipoAtendimentoPai.class)
public class TipoAtendimentoPaiConverter implements Converter {

	private TipoAtendimentoPaiRepository tipoAtendimentoPaiRepository;

	public TipoAtendimentoPaiConverter() {
		this.tipoAtendimentoPaiRepository = CDIServiceLocator.getBean(TipoAtendimentoPaiRepository.class);
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		TipoAtendimentoPai retorno = null;

		if (value != null) {
			retorno = this.tipoAtendimentoPaiRepository.findOne(new Long(value));
		}

		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {

		if (value != null) {
			TipoAtendimentoPai tipoAtendimentoPai = (TipoAtendimentoPai) value;

			return tipoAtendimentoPai.getId() == null ? null : tipoAtendimentoPai.getId().toString();
		}

		return "";
	}

}
