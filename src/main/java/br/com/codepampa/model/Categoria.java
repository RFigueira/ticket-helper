package br.com.codepampa.model;

import br.com.codepampa.enumerator.StatusEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.validation.constraints.Size;


@Data
@NoArgsConstructor
@Entity
@Table(name = "categoria")
public class Categoria extends BaseEntity {

    @Size(max = 128)
    @Column(name = "nome_categoria")
    private String nome;

    @Enumerated(EnumType.STRING)
    @Column
    private StatusEnum status = StatusEnum.ATIVO;

    @Size(max = 255)
    @Column(name = "descricao")
    private String descricao;

}
