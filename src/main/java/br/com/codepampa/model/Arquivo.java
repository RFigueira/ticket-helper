package br.com.codepampa.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Getter
@Setter
@Entity
@Table(name = "arquivo")
public class Arquivo extends BaseEntity {

    public Arquivo(){

    }

    public Arquivo(String path, String nome){
        this.path = path;
        this.nome = nome;
    }

    @Size(max = 100)
    @Column(name = "path")
    private String path;

    @Size(max = 100)
    @Column(name = "nome")
    private String nome;

}
