package br.com.codepampa.controller;

import br.com.codepampa.enumerator.CategoriaPessoaEnum;
import br.com.codepampa.model.Arquivo;
import br.com.codepampa.model.Categoria;
import br.com.codepampa.model.InteracaoTicket;
import br.com.codepampa.model.Pessoa;
import br.com.codepampa.model.Ticket;
import br.com.codepampa.security.Access;
import br.com.codepampa.service.CategoriaService;
import br.com.codepampa.service.PessoaService;
import br.com.codepampa.service.TicketService;
import br.com.codepampa.util.Bundles;
import br.com.codepampa.util.Helper;
import br.com.codepampa.util.JSFUtil;
import com.ocpsoft.pretty.faces.annotation.URLAction;
import com.ocpsoft.pretty.faces.annotation.URLMapping;
import com.ocpsoft.pretty.faces.annotation.URLMappings;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.io.IOUtils;
import org.omnifaces.util.Messages;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.Part;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

//Gerador de getters e setters
@Getter
@Setter
@ManagedBean
@ViewScoped
@URLMappings(mappings = {
    @URLMapping(id = "ticket-novo", pattern = "/gerenciador/novo-ticket/", viewId = "/faces/pages/protegido/ticket/ticket.xhtml"),
    @URLMapping(id = "tickets", pattern = "/gerenciador/tickets/", viewId = "/faces/pages/protegido/ticket/tickets.xhtml"),
    @URLMapping(id = "ticket", pattern = "/gerenciador/ticket/#{ticketController.ticketId}/", viewId = "/faces/pages/protegido/ticket/ticket.xhtml"),
})
public class TicketController implements Serializable {

    private static final long serialVersionUID = 1L;

    private TicketService ticketService;
    private CategoriaService categoriaService;
    private PessoaService pessoaService;
    private Ticket ticket;
    private List<Ticket> tickets= new ArrayList<>();
    private List<Categoria> categorias = new ArrayList<>();
    private List<Pessoa> solicitantes = new ArrayList<>();
    private List<Pessoa> responsavel = new ArrayList<>();
    private List<Pessoa> pessoas = new ArrayList<>();
    private Long ticketId;
    private InteracaoTicket interacaoTicket;
    private Part arquivo;
    private byte[] imagem;






    public TicketController() {
        ticket = new Ticket();
        ticketService = new TicketService();
        categoriaService = new CategoriaService();
        pessoaService = new PessoaService();
        categorias = categoriaService.findAllCriteria();
        pessoas = pessoaService.findAllCriteria();
        solicitantes = pessoas
                .stream()
                .filter(p-> p.getCategoriaPessoaEnum() == CategoriaPessoaEnum.USUARIO)
                .collect(Collectors.toList());

        responsavel = pessoas
                .stream()
                .filter(p-> p.getCategoriaPessoaEnum() != CategoriaPessoaEnum.USUARIO)
                .collect(Collectors.toList());

    }

    public void salvar() {
        try {
            //TODO: descomentar apos implementar upload
            // uploadArquivo();
            ticketService.save(ticket);
            ticketId = ticket.getId();
            Messages.addGlobalInfo(Bundles.getString("operacao.realizada.sucesso"));
            JSFUtil.prettyRedirect("ticket", ticketId);
        } catch (Exception e){
            //TODO : tratar erro de verdade, aqui estou generalizando isso eh ruim :/
            Messages.addGlobalError(Bundles.getString("operacao.nao.realizada"));
        }
    }

    @URLAction(mappingId = "ticket", onPostback = false)
    public void carregarConteudoPorId() {
        ticket = ticketService.findById(ticketId);
        interacaoTicket = new InteracaoTicket(Access.carregarUsuarioDaSession(), ticket);
    }

    @URLAction(mappingId = "tickets", onPostback = false)
    public List<Ticket> pupularLista() {
        if (tickets.isEmpty()) {
            tickets = ticketService.findByPessoa(Access.carregarUsuarioDaSession());
        }
        return tickets;
    }

    public void interagirInternamente() {
        ticket.addInteracaoInterna(interacaoTicket);
        salvar();
    }
    public void interagirExternamente() {
        ticket.addInteracaoExterna(interacaoTicket);
        salvar();

    }
    private void uploadArquivo() {
        if(arquivo!= null) {
            InputStream input;
            try {
                for(Part part : Helper.getAllParts(arquivo)) {
                    input = part.getInputStream();
                    //Apache Commons IO
                    imagem = IOUtils.toByteArray(input);
                    String path = Helper.returnPathArquivo(arquivo);
                    String pathFisico = (FacesContext.getCurrentInstance().getExternalContext().getRealPath("") + path );
                    File saida = new File(pathFisico);
                    OutputStream os = new FileOutputStream(saida);
                    os.write(imagem);
                    os.flush();
                    Arquivo a = new Arquivo(path, arquivo.getSubmittedFileName());
                    ticket.addAnexo(a);
                }
            } catch (Exception ex) {
                Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, "Erro upload imagem", ex);
            }
        }
    }

    public void removerArquivo(Arquivo arquivo) {
        ticket.removerAnexo(arquivo);
        ticketService.save(ticket);
        Messages.addGlobalInfo(Bundles.getString("operacao.realizada.sucesso"));
    }


}
