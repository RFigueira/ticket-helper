package br.com.codepampa.security;

import br.com.codepampa.model.Pessoa;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

public class Access {

    public Access() {

    }

    public static void inserirUsuarioNaSession(Pessoa pessoa) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpSession sessaoHttp = (HttpSession) facesContext.getExternalContext().getSession(true);
        sessaoHttp.setAttribute("usuarioLogado", pessoa);

    }


    public static Pessoa carregarUsuarioDaSession() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpSession sessaoHttp = (HttpSession) facesContext.getExternalContext().getSession(true);
        if (sessaoHttp.getAttribute("usuarioLogado") != null) {
            return (Pessoa) sessaoHttp.getAttribute("usuarioLogado");
        } else {
            return null;
        }
    }

    public static void excluirUsuarioDaSession() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpSession sessaoHttp = (HttpSession) facesContext.getExternalContext().getSession(true);
        sessaoHttp.removeAttribute("usuarioLogado");

    }

}
