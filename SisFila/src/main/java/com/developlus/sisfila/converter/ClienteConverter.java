package com.developlus.sisfila.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import com.developlus.sisfila.model.Cliente;
import com.developlus.sisfila.repository.ClienteRepository;
import com.developlus.sisfila.util.cdi.CDIServiceLocator;

@FacesConverter(forClass = Cliente.class)
public class ClienteConverter implements Converter {

	private ClienteRepository clienteRepository;

	public ClienteConverter() {
		this.clienteRepository = CDIServiceLocator.getBean(ClienteRepository.class);
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Cliente retorno = null;

		if (value != null) {
			retorno = this.clienteRepository.findOne(new Long(value));
		}

		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Cliente cliente = (Cliente) value;

			return cliente.getId() == null ? null : cliente.getId().toString();
		}

		return "";
	}

}