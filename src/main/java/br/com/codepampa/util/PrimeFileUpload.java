package br.com.codepampa.util;

import org.primefaces.component.fileupload.FileUploadRenderer;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;


public class PrimeFileUpload extends FileUploadRenderer {

        @Override
        public void decode(FacesContext context, UIComponent component) {
            if (context.getExternalContext().getRequestContentType().toLowerCase().startsWith("multipart/")) {
                super.decode(context, component);

        }
    }
}
