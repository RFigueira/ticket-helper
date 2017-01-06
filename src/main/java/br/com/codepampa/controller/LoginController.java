package br.com.codepampa.controller;

import br.com.codepampa.model.Pessoa;
import br.com.codepampa.security.Access;
import br.com.codepampa.service.PessoaService;
import br.com.codepampa.util.Bundles;
import br.com.codepampa.util.JSFUtil;
import com.ocpsoft.pretty.faces.annotation.URLMapping;
import com.ocpsoft.pretty.faces.annotation.URLMappings;
import lombok.Getter;
import lombok.Setter;
import org.omnifaces.util.Messages;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.io.Serializable;
import java.sql.SQLException;


@Getter
@Setter
@ManagedBean
@RequestScoped
@URLMappings(mappings = {
        @URLMapping(onPostback = false ,id = "login", pattern = "/login/", viewId = "/faces/login.xhtml")
})
public class LoginController implements Serializable {

    private Pessoa pessoa;
    private PessoaService pessoaService;
    private String classCss;


    public LoginController() {
        pessoaService = new PessoaService();
        pessoa = carregarUsuarioDaSession();
    }


    public void logar() throws SQLException {
        pessoa = pessoaService.getCrendeciais(pessoa);
        if (pessoa == null) {
            Messages.addGlobalWarn(Bundles.getString("login.senha.invalida"));
            JSFUtil.prettyRedirect("login");
            return;
        }
        Access.inserirUsuarioNaSession(pessoa);
        JSFUtil.prettyRedirect("dashboard");
    }

    public void logout() {
        Access.excluirUsuarioDaSession();
        JSFUtil.prettyRedirect("login");
    }

    private Pessoa carregarUsuarioDaSession() {
        pessoa = Access.carregarUsuarioDaSession();
        if (pessoa == null) {
            return new Pessoa();
        }
        return pessoa;
    }

}
