package br.com.codepampa.service;


public interface ServiceGeneric<EntityManager, EntityManagerFactory> {

    EntityManagerFactory getConexaoJPA();

    void closeConexao();

    EntityManager factoryEntityManagerCode();

}
