package br.com.codepampa.controller;

import br.com.codepampa.model.Pessoa;
import br.com.codepampa.service.PessoaService;
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
    @URLMapping(id = "pessoa-nova", pattern = "/gerenciador/nova-pessoa/", viewId = "/faces/pages/protegido/pessoa/pessoa.xhtml"),
    @URLMapping(id = "pessoas", pattern = "/gerenciador/pessoas/", viewId = "/faces/pages/protegido/pessoa/pessoas.xhtml"),
    @URLMapping(id = "pessoa-editar", pattern = "/gerenciador/editar-pessoa/#{pessoaController.pessoaId}/", viewId = "/faces/pages/protegido/pessoa/pessoa.xhtml")
})
public class PessoaController implements Serializable {

    private static final long serialVersionUID = 1L;

    private PessoaService pessoaService;
    private Pessoa pessoa;
    private List<Pessoa> pessoas= new ArrayList<>();
    private Long pessoaId;


    public PessoaController() {
        pessoa = new Pessoa();
        pessoaService = new PessoaService();
    }

    public void salvar() {
        try {
            pessoaService.inserir(pessoa);
            pessoaId = pessoa.getId();
            Messages.addGlobalInfo(Bundles.getString("operacao.realizada.sucesso"));
            JSFUtil.prettyRedirect("pessoa-editar", pessoaId);
        } catch (Exception e){
            //TODO : tratar erro de verdade, aqui estou generalizando isso eh ruim :/
            Messages.addGlobalError(Bundles.getString("operacao.nao.realizada"));
        }
    }

    @URLAction(mappingId = "pessoa-editar", onPostback = false)
    public void carregarPessoaPorId() {
        pessoa = pessoaService.findById(pessoaId);
    }

    @URLAction(mappingId = "pessoas", onPostback = false)
    public List<Pessoa> pupularLista() {
        if (pessoas.isEmpty()) {
            pessoas = pessoaService.findAllCriteria();
        }
        return pessoas;
    }


}
