package br.com.codepampa.enumerator;

import br.com.codepampa.util.CodePampaInterfacesEnum;

public enum StatusTicketEnum implements CodePampaInterfacesEnum {
    ABERTO("Aberto"),
    AGUARDANDO_RESPOSTA("Aguardando resposta"),
    EM_ANDAMENTO("Em andamento"),
    EM_ANALISE("Em Análise"),
    FECHADO("Fechado");

    private String nome;

    private StatusTicketEnum(String nome) {
        this.nome = nome;
    }

    @Override
    public String getNome() {
        return nome;
    }

}
