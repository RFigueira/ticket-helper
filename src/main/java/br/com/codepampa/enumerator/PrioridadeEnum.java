package br.com.codepampa.enumerator;

import br.com.codepampa.util.CodePampaInterfacesEnum;

public enum PrioridadeEnum implements CodePampaInterfacesEnum {

    ALTA("Alta"), MEDIA("Média"),NORMAL("Normal");
    private String nome;

    private PrioridadeEnum(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
