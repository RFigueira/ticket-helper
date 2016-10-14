package br.com.codepampa.filter;


import br.com.codepampa.model.Pessoa;
import br.com.codepampa.util.JSFUtil;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "LoginFilter", urlPatterns = "/pages/protegido/*")
public class LoginFilter implements Filter {
 
     @Override
    public void init(FilterConfig filterConfig) throws ServletException {
     
    }
   
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpSession sessao = ((HttpServletRequest) request).getSession();
        Pessoa pessoa = (Pessoa) sessao.getAttribute("usuarioLogado");
        if (pessoa == null) {
            JSFUtil.prettyRedirect("login");
        } else {
            chain.doFilter(request, response);
        }
    }

 
    @Override
    public void destroy() {
    }


   


}
