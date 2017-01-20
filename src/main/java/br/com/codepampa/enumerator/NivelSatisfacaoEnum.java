package br.com.codepampa.enumerator;

import br.com.codepampa.util.CodePampaInterfacesEnum;

public enum NivelSatisfacaoEnum implements CodePampaInterfacesEnum {

    OTIMO("Ótimo"), MUITO_BOM("Muito bom"),
    BOM("Bom"), NORMAL("Normal") ,RUIM("Ruim"),
    MUITO_RUIM("Muito ruim");

    private String nome;

    private NivelSatisfacaoEnum(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
