package br.com.codepampa.model;

import br.com.codepampa.enumerator.CategoriaPessoaEnum;
import br.com.codepampa.enumerator.StatusEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;


@Data
@NoArgsConstructor
@Entity
@Table(name = "pessoa")
@NamedQueries({
        @NamedQuery(name = "Pessoa.getCredential", query = "SELECT p FROM Pessoa p WHERE p.email = :email AND p.senha = :senha AND p.status = :status "),
        @NamedQuery(name = "Pessoa.findByCategoriaPessoa", query = "SELECT p FROM Pessoa p WHERE p.categoriaPessoaEnum = :categoriaPessoa"),
        @NamedQuery(name = "Pessoa.findResponsaveis", query = "SELECT p FROM Pessoa p WHERE p.categoriaPessoaEnum <> :categoriaPessoa")
})
public class Pessoa extends BaseEntity {


    @Size(max = 250)
    @Column(name = "nome", length = 250)
    private String nome;

    @Size(max = 150)
    @Column(name = "email", length = 150)
    private String email;

    @Size(max = 255)
    @Column(name = "senha", length = 255)
    private String senha;

    @Size(max = 250)
    @Column(name = "rua", length = 250)
    private String rua;

    @Size(max = 6)
    @Column(name = "numero", length = 6)
    private String numero;

    @Size(max = 150)
    @Column(name = "complemento", length = 150)
    private String complemento;

    @Enumerated(EnumType.STRING)
    @Column(name = "stauts")
    private StatusEnum status = StatusEnum.ATIVO;

    @Enumerated(EnumType.STRING)
    @Column(name = "categoria")
    private CategoriaPessoaEnum categoriaPessoaEnum = CategoriaPessoaEnum.ADMIN;


}
