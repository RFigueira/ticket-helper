package br.com.codepampa.enumerator;

import br.com.codepampa.util.CodePampaInterfacesEnum;

public enum CategoriaPessoaContatoEnum implements CodePampaInterfacesEnum {
    ADMIN("Administrador"), ANALISTA("Analista"), USUARIO("Usuário"), PRESTADOR_SERVICO("Prestador Serviço");


    private String nome;

    private CategoriaPessoaContatoEnum(String nome) {
        this.nome = nome;
    }

    @Override
    public String getNome() {
        return nome;
    }

}
