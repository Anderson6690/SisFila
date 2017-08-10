package com.developlus.sisfila.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import com.developlus.sisfila.model.Estado;
import com.developlus.sisfila.repository.EstadoReṕository;
import com.developlus.sisfila.util.cdi.CDIServiceLocator;

@FacesConverter(forClass = Estado.class)
public class EstadoConverter implements Converter {

	private EstadoReṕository EstadoReṕository;

	public EstadoConverter() {
		this.EstadoReṕository = CDIServiceLocator.getBean(EstadoReṕository.class);
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Estado retorno = null;

		if (value != null) {
			retorno = this.EstadoReṕository.findOne(new Long(value));
		}

		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Estado estado = (Estado) value;

			return estado.getId() == null ? null : estado.getId().toString();
		}

		return "";
	}

}