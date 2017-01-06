package br.com.codepampa.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "interacao_ticket")
public class InteracaoTicket extends BaseEntity {

    @Lob
    @Type(type = "org.hibernate.type.TextType")
    @Column(name = "descricao")
    private String descricao;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_pessoa")
    private Pessoa pessoa;

    @NotNull
    @Column(name = "data_hora_criacao")
    private LocalDateTime dataHoraCriacao;

    @Column
    private boolean interna;

    @Column (name = "reaberto", columnDefinition = "boolean default false")
    private boolean reaberto;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_ticket")
    private Ticket ticket;

    public InteracaoTicket(Pessoa pessoa, Ticket ticket) {
        this();
        this.pessoa = pessoa;
        this.ticket = ticket;
    }


}
