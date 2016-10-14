package br.com.codepampa.controller;

import br.com.codepampa.enumerator.CategoriaContatoEnum;
import br.com.codepampa.model.Contato;
import br.com.codepampa.service.ContatoService;
import br.com.codepampa.util.Bundles;
import br.com.codepampa.util.JSFUtil;
import com.ocpsoft.pretty.faces.annotation.URLAction;
import com.ocpsoft.pretty.faces.annotation.URLMapping;
import com.ocpsoft.pretty.faces.annotation.URLMappings;
import lombok.Data;
import org.omnifaces.util.Messages;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.ArrayList;
import java.util.Collection;


@Data
@ManagedBean
@ViewScoped
@URLMappings(mappings = {
        @URLMapping(id = "contatos", pattern = "/gerenciador/contatos/", viewId = "/faces/pages/protegido/contato/contatos.xhtml"),
        @URLMapping(id = "contato-view", pattern = "/gerenciador/contato/#{contatoController.contatoId}/", viewId = "/faces/pages/protegido/contato/contato-view.xhtml"),
})

public class ContatoController {

    private Contato contato = new Contato();
    private ContatoService contatoService;
    private Collection<Contato> contatos = new ArrayList<>();
    private Long contatoId;
    
    public ContatoController() {
        contatoService = new ContatoService();
    }

    @URLAction(mappingId = "contatos", onPostback = false)
    public Collection<Contato> pupularLista() {
        if (contatos.isEmpty()) {
            contatos =  contatoService.findAll();
        }
        return contatos;
    }

    @URLAction(mappingId = "contato-view", onPostback = false)
    public void carregarConteudoPorId() {
        contato = contatoService.findById(contatoId);

    }


    public void Salvar(){
        if(!contato.getCategoriaContato().equals(CategoriaContatoEnum.SUGESTOES)){
          //  contato.setCategoriaPessoaContato(CategoriaPessoaContatoEnum.NAO_SE_APLICA);
        }
        contatoService.save(contato);
        JSFUtil.prettyRedirect("contato");
        Messages.addGlobalInfo(Bundles.getString("contato.realizado.sucesso"));

    }
    
    
    
}
