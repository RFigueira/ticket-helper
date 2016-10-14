package br.com.codepampa.model;

import br.com.codepampa.enumerator.PrioridadeEnum;
import br.com.codepampa.enumerator.StatusTicketEnum;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "ticket")
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




}
