package br.com.codepampa.converter;


import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;


@FacesConverter("localDateTimeFacesConverterInteracao")
public class LocalDateTimeFacesConverterInteracao extends LocalDateTimeFacesConverter {


    @Override
    public String getAsString(FacesContext context, UIComponent component, Object localDateTimeValue) {

        if (null == localDateTimeValue) {

            return "";
        }

        return ((LocalDateTime) localDateTimeValue)
                .format(DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm")
                        .withZone(ZoneId.systemDefault()));
    }
}
