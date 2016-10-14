package br.com.codepampa.enumerator;

import br.com.codepampa.util.CodePampaInterfacesEnum;


public enum CategoriaEnum implements CodePampaInterfacesEnum {
    MURAL("Mural"), QUEM_SOMOS("Quem Somos"), EVENTOS("Eventos"),
    PADRAO("Padrão");

 
    private String nome;

    private CategoriaEnum(String nome) {
        this.nome = nome;
    }

    @Override
    public String getNome() {
        return nome;
    }

}
