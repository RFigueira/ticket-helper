package br.com.codepampa.enumerator;

import br.com.codepampa.util.CodePampaInterfacesEnum;


public enum ReferenciaEnum implements CodePampaInterfacesEnum{
    ALTERACAO("Alteração"), CADASTRO("Cadastro"), EXCLUSSAO("Exclussão"), 
    ORIGEMLISTAGEM("Origem-Listagem")
    ;
    private String nome;
    
    private ReferenciaEnum(String nome){
        this.nome = nome;
    }
    
    
    @Override
    public String getNome() {
      return  nome;
    }
    
}
