package br.com.biblioteca.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.biblioteca.dao.EstadoDAO;
import br.com.biblioteca.model.Estado;

@FacesConverter(value="estadoConverter")
public class EstadoConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if(value != null || !value.isEmpty()){
			EstadoDAO estadoDao = new EstadoDAO();
			Estado estado = estadoDao.buscar(Integer.valueOf(value));
			return estado;
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(value instanceof Estado){
			Estado estado = (Estado)value;
			return String.valueOf(estado.getIdEstado());
		}
		return "";
	}

}
