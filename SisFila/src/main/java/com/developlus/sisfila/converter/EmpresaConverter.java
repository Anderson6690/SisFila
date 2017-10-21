package com.developlus.sisfila.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.developlus.sisfila.model.Empresa;
import com.developlus.sisfila.repository.EmpresaRepository;
import com.developlus.sisfila.util.cdi.CDIServiceLocator;

@FacesConverter(forClass = Empresa.class)
public class EmpresaConverter implements Converter {

	private EmpresaRepository empresaRepository;

	public EmpresaConverter() {
		this.empresaRepository = CDIServiceLocator.getBean(EmpresaRepository.class);
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Empresa retorno = null;

		if (value != null) {
			retorno = this.empresaRepository.findOne(new Long(value));
		}

		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Empresa empresa = (Empresa) value;

			return empresa.getId() == null ? null : empresa.getId().toString();
		}

		return "";
	}

}