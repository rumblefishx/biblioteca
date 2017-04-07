package br.com.biblioteca.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.biblioteca.dao.CidadeDAO;
import br.com.biblioteca.model.Cidade;

@FacesConverter(value = "cidadeConverter")
public class CidadeConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value != null && !value.equals("")) {
			CidadeDAO dao = new CidadeDAO();
			return dao.buscar(Integer.valueOf(value));
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value instanceof Cidade) {
			Cidade municipio = (Cidade) value;
			return String.valueOf(municipio.getIdCidade());
		}
		return "";
	}

}
