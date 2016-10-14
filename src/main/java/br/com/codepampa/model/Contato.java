package br.com.codepampa.model;

import br.com.codepampa.enumerator.CategoriaContatoEnum;
import br.com.codepampa.enumerator.CategoriaPessoaContatoEnum;
import br.com.codepampa.enumerator.StatusTicketEnum;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "contato")
public class Contato extends BaseEntity {

    @Column(name = "nome", length = 125)
    private String nome;

    @Column(name = "nome_aluno", length = 125)
    private String nomeAluno;

    @Column(name = "nome_professor", length = 125)
    private String nomeProfessor;

    @Column(name = "turma", length = 50)
    private String turma;

    @Column(name = "assunto_reuniao", length = 150)
    private String assuntoReuniao;

    @Column(name = "email", length = 50)
    private String email;

    @Column(name = "telefone", length = 100)
    private String telefone;

    @Column(name = "mensagem", length = 2500)
    private String mensagem;

    @Column(name = "data_contato")
    private LocalDateTime dataContato;

    @Column(name = "data_falta")
    private LocalDate dataFalta;


    @Column(name = "data_ultima_atualizacao")
    private LocalDateTime dataUltimaAtualizacao;

    @Enumerated(EnumType.STRING)
    @Column
    private CategoriaContatoEnum categoriaContato;

    @Enumerated(EnumType.STRING)
    @Column
    private StatusTicketEnum statusContato;

    @Enumerated(EnumType.STRING)
    @Column
    private CategoriaPessoaContatoEnum categoriaPessoaContato;


    public Contato(){
        dataContato = LocalDateTime.now();
        //statusContato = StatusTicketEnum.NAO_LIDO;
        categoriaContato = CategoriaContatoEnum.CONTATO;
        //categoriaPessoaContato = CategoriaPessoaContatoEnum.PAI_MAE_RESPONSAVEL;
    }
}
