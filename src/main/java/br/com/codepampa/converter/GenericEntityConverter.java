package br.com.codepampa.converter;


import br.com.codepampa.model.BaseModel;
import org.omnifaces.converter.SelectItemsConverter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;
import java.io.Serializable;

@FacesConverter("genericEntityConverter")
public class GenericEntityConverter  extends SelectItemsConverter {
    @Override
    @SuppressWarnings("unchecked")
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        Serializable id = (value instanceof BaseModel) ? ((BaseModel) value).getId() : null;
        return (id != null) ? id.toString() : null;
    }
}
