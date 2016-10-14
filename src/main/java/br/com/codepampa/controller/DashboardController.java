package br.com.codepampa.controller;

import com.ocpsoft.pretty.faces.annotation.URLMapping;
import com.ocpsoft.pretty.faces.annotation.URLMappings;
import lombok.Getter;
import lombok.Setter;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.servlet.http.Part;

@Getter
@Setter
@ManagedBean
@RequestScoped
@URLMappings(mappings = {
    @URLMapping(onPostback = false ,id = "dashboard", pattern = "/gerenciador/dashboard/", viewId = "/faces/pages/protegido/dashboard/dashboard.xhtml")
})
public class DashboardController {


    private Part arquivo;
    private byte[] imagem;



    public DashboardController() {
    }

    //TODO: Serve para testar o upload
   /* public void geraImagem() {
        InputStream input;
        try {
            input = arquivo.getInputStream();
            //Apache Commons IO
            imagem = IOUtils.toByteArray(input);
            String path =  FacesContext.getCurrentInstance().getExternalContext().getRealPath("");
            File saida = new File(path + Helper.pathUploadFile + LocalDateTime.now()+".png");

            OutputStream os = new FileOutputStream(saida);
            os.write(imagem);
            os.flush();
        } catch (Exception ex) {
            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }*/

}
