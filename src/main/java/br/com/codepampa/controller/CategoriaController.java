package br.com.codepampa.controller;

import br.com.codepampa.model.Categoria;
import br.com.codepampa.service.CategoriaService;
import br.com.codepampa.util.Bundles;
import br.com.codepampa.util.JSFUtil;
import com.ocpsoft.pretty.faces.annotation.URLAction;
import com.ocpsoft.pretty.faces.annotation.URLMapping;
import com.ocpsoft.pretty.faces.annotation.URLMappings;
import lombok.Data;
import org.omnifaces.util.Messages;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@ManagedBean
@ViewScoped
@URLMappings(mappings = {
    @URLMapping(id = "categoria-nova", pattern = "/gerenciador/nova-categoria/", viewId = "/faces/pages/protegido/categoria/categoria.xhtml"),
    @URLMapping(id = "categorias", pattern = "/gerenciador/categorias/", viewId = "/faces/pages/protegido/categoria/categorias.xhtml"),
    @URLMapping(id = "categoria-editar", pattern = "/gerenciador/editar-categoria/#{categoriaController.categoriaId}/", viewId = "/faces/pages/protegido/categoria/categoria.xhtml")
})
public class CategoriaController implements Serializable {

    private static final long serialVersionUID = 1L;

    private CategoriaService categoriaService;
    private Categoria categoria;
    private List<Categoria> categorias= new ArrayList<>();
    private Long categoriaId;


    public CategoriaController() {
        categoria = new Categoria();
        categoriaService = new CategoriaService();
    }

    public void salvar() {
        try {
            categoriaService.save(categoria);
            categoriaId = categoria.getId();
            Messages.addGlobalInfo(Bundles.getString("operacao.realizada.sucesso"));
            JSFUtil.prettyRedirect("categoria-editar", categoriaId);
        } catch (Exception e){
            //TODO : tratar erro de verdade, aqui estou generalizando isso eh ruim :/
            Messages.addGlobalError(Bundles.getString("operacao.nao.realizada"));
        }
    }

    @URLAction(mappingId = "categoria-editar", onPostback = false)
    public void carregarConteudoPorId() {
        categoria = categoriaService.findById(categoriaId);
    }

    @URLAction(mappingId = "categorias", onPostback = false)
    public List<Categoria> pupularLista() {
        if (categorias.isEmpty()) {
            categorias = categoriaService.findAllCriteria();
        }
        return categorias;
    }


}
