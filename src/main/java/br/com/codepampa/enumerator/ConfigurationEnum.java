package br.com.codepampa.enumerator;

import br.com.codepampa.util.CodePampaInterfacesEnum;

public enum ConfigurationEnum implements CodePampaInterfacesEnum {
    NAME_DAFAULT_IMAGE("image-")
    ;
        private String nome;

    private ConfigurationEnum(String nome) {
        this.nome = nome;

    }

    @Override
    public String getNome() {
        return nome;
    }

}
