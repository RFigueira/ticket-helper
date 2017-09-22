package br.com.codepampa.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class ServiceFactory implements ServiceGeneric<EntityManager, EntityManagerFactory>{

    private static EntityManager entityManager;
    private static EntityManagerFactory emf;

    @Override
    public EntityManagerFactory getConexaoJPA() {
        if ((emf == null) || (!emf.isOpen())) {
            emf = Persistence.createEntityManagerFactory("br.com.codepampa_tickethelper_war_1.0PU");
        }
        return emf;
    }

    @Override
    public void closeConexao() {
        if (emf.isOpen()) {
            emf.close();
        }
    }

    @Override
    public EntityManager factoryEntityManagerCode() {
        return entityManager = getConexaoJPA().createEntityManager();
    }
}
