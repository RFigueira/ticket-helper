package br.com.codepampa.enumerator;

import br.com.codepampa.util.CodePampaInterfacesEnum;

public enum CategoriaContatoEnum implements CodePampaInterfacesEnum {
     CONTATO("Contato"), COMUNICADO_DE_FALTA("Comunicado de falta"),
     SOLICITACAO_REUNIAO("Solicitação de reunião"), SUGESTOES("Sugestões");
    private String nome;

    private CategoriaContatoEnum(String nome) {
        this.nome = nome;
    }

    @Override
    public String getNome() {
        return nome;
    }

    public boolean isComunicadoDeFalta(){
        return this == COMUNICADO_DE_FALTA;
    }

    public boolean isSugestoes(){
        return this == SUGESTOES;
    }

    public boolean isContato(){
        return this == CONTATO;
    }

    public boolean isSolicitacaoReuniao(){
        return this == SOLICITACAO_REUNIAO;
    }

    public String tagLabelMensagem(){
        if(this == COMUNICADO_DE_FALTA){
            return "Motivo: ";
        }
        else if(this == SOLICITACAO_REUNIAO){
            return "Motivo da reunião (breve resumo): ";
        }
        return "Mensagem";

    }

    public String tagLabelData(){
        if(this == COMUNICADO_DE_FALTA){
            return "Data da fatal: ";
        }
        return "Data da reunião: ";

    }

}
