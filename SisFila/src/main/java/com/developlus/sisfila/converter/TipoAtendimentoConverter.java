package com.developlus.sisfila.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.developlus.sisfila.model.TipoAtendimento;
import com.developlus.sisfila.repository.TipoAtendimentoRepository;
import com.developlus.sisfila.util.cdi.CDIServiceLocator;

@FacesConverter(forClass = TipoAtendimento.class)
public class TipoAtendimentoConverter implements Converter {

	private TipoAtendimentoRepository tipoAtendimentoRepository;

	public TipoAtendimentoConverter() {
		this.tipoAtendimentoRepository = CDIServiceLocator.getBean(TipoAtendimentoRepository.class);
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		TipoAtendimento retorno = null;

		if (value != null) {
			retorno = this.tipoAtendimentoRepository.findOne(new Long(value));
		}

		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {

		if (value != null) {
			TipoAtendimento tipoAtendimento = (TipoAtendimento) value;

			return tipoAtendimento.getId() == null ? null : tipoAtendimento.getId().toString();
		}

		return "";
	}

}
