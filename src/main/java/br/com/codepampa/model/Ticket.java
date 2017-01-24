package br.com.codepampa.model;

import br.com.codepampa.enumerator.NivelSatisfacaoEnum;
import br.com.codepampa.enumerator.PrioridadeEnum;
import br.com.codepampa.enumerator.StatusTicketEnum;
import lombok.Data;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static java.util.stream.Collectors.toList;

//insert int pessoa values ADMIN, foolha@gmail.com,	Rodrigo Freitas, 532, Capitão ceriaco garcia, 81dc9bdb52d04dc20036dbd8313ed055,	ATIVO

@Data
@Entity
@Table(name = "ticket")
@NamedQueries({
        @NamedQuery(name = "Ticket.findTicketsByResponsavel", query = "SELECT DISTINCT t FROM Ticket t WHERE t.responsavel = :responsavel"),
        @NamedQuery(name = "Ticket.findTicketsBySolicitante", query = "SELECT DISTINCT t FROM Ticket t WHERE t.solicitante = :solicitante"),
        @NamedQuery(name = "Ticket.findTicketsByPrestadorDeServico", query = "SELECT DISTINCT t FROM Ticket t WHERE t.prestadorServico = :prestadorServico")
})
public class Ticket extends BaseEntity {

    @Column(name = "titulo", length = 300)
    private String titulo;

    @Column(name = "descricao", length = 10000)
    private String descricao;


    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;


    @ManyToOne
    @JoinColumn(name = "id_responsavel")
    private Pessoa responsavel;


    @ManyToOne
    @JoinColumn(name = "id_solicitante")
    private Pessoa solicitante;

    @Enumerated(EnumType.STRING)
    @Column
    private StatusTicketEnum status = StatusTicketEnum.ABERTO;


    @Enumerated(EnumType.STRING)
    @Column
    private PrioridadeEnum prioridade = PrioridadeEnum.NORMAL;

    @Column(name = "data_hora_criacao")
    private LocalDateTime dataHoraCriacao = LocalDateTime.now();

    @Column(name = "data_hora_fechamento")
    private LocalDateTime dataHoraFechamento;


    @OneToMany(mappedBy = "ticket", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<InteracaoTicket> interacoes = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "id_prestadorServico")
    private Pessoa prestadorServico;

    @Enumerated(EnumType.STRING)
    @Column
    private NivelSatisfacaoEnum nivelSatisfacaoEnum;

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Arquivo> arquivos = new ArrayList<>();

    public void addAnexo(Arquivo arquivo) {
        arquivos.add(arquivo);
    }

    public void removerAnexo(Arquivo arquivo) {
        arquivos.remove(arquivo);
    }

    public void addInteracaoExterna(InteracaoTicket interacaoTicket) {
        addInteracao(interacaoTicket, false);
    }

    public void addInteracaoInterna(InteracaoTicket interacaoTicket) {
        addInteracao(interacaoTicket, true);
    }

    private void addInteracao(InteracaoTicket interacaoTicket, boolean interna) {

        interacaoTicket.setInterna(interna);
        interacoes.add(interacaoTicket);

        if (interacaoTicket.getDataHoraCriacao() == null) {
            interacaoTicket.setDataHoraCriacao(LocalDateTime.now());
        }
    }

    public List<InteracaoTicket> getInteracoesByPessoa(Pessoa usuarioLogado) {
        return interacoes.stream()
                .filter(i -> usuarioLogado.getCategoriaPessoaEnum().isResponsavel() || !i.isInterna())
                .sorted(Comparator.comparing(InteracaoTicket::getDataHoraCriacao))
                .collect(toList());
    }

}
