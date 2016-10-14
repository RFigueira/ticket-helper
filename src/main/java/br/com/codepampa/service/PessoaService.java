package br.com.codepampa.service;


import br.com.codepampa.model.Pessoa;

import javax.persistence.NoResultException;

public class PessoaService extends GenericService<Pessoa,Long> {

    public Pessoa getCrendeciais(Pessoa pessoa) {
        try {
           return entityManager.createNamedQuery("Pessoa.getCredential", Pessoa.class)
                    .setParameter("senha", pessoa.getSenha())
                    .setParameter("email", pessoa.getEmail())
                    .getSingleResult();
        } catch(NoResultException e){
            System.out.println(e);
            return null;
        }
    }

}
