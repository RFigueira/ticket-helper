package br.com.codepampa.enumerator;

import br.com.codepampa.util.CodePampaInterfacesEnum;

public enum StatusEnum implements CodePampaInterfacesEnum {

    ATIVO("Ativo"), INATIVO("Inativo"), EXCLUIDO("Excluído"), CANCELADO("Cancelado");
    private String nome;

    private StatusEnum(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
