package br.com.codepampa.enumerator;

import br.com.codepampa.util.CodePampaInterfacesEnum;

public enum CategoriaPessoaEnum implements CodePampaInterfacesEnum {
    ADMIN("Administrador"), ANALISTA("Analista"), USUARIO("Usuário"), PRESTADOR_SERVICO("Prestador Serviço");


    private String nome;

    private CategoriaPessoaEnum(String nome) {
        this.nome = nome;
    }

    @Override
    public String getNome() {
        return nome;
    }

    public boolean isResponsavel(){
       return this == ADMIN || this == ANALISTA
               || this == PRESTADOR_SERVICO;
    }

    public boolean isUsuarioInterno(){
        return this == ADMIN || this == ANALISTA;
    }

    public boolean isPrestadorDeServico(){
        return this == PRESTADOR_SERVICO;
    }

    public boolean isSolicitante(){
        return this == USUARIO;
    }
}
