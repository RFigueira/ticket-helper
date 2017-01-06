package br.com.codepampa.service;


import br.com.codepampa.enumerator.CategoriaPessoaEnum;
import br.com.codepampa.enumerator.StatusEnum;
import br.com.codepampa.model.Pessoa;
import br.com.codepampa.util.CriptografiaHelper;

import javax.persistence.NoResultException;
import java.util.List;

public class PessoaService extends GenericService<Pessoa,Long> {

    public Pessoa getCrendeciais(Pessoa pessoa) {
        try {
           return entityManager.createNamedQuery("Pessoa.getCredential", Pessoa.class)
                    .setParameter("senha", CriptografiaHelper.getCriptografada(pessoa.getSenha()))
                    //.setParameter("senha", pessoa.getSenha())
                    .setParameter("email", pessoa.getEmail())
                    .setParameter("status", StatusEnum.ATIVO)
                    .getSingleResult();
        } catch(NoResultException e){
            System.out.println(e);
            return null;
        }
    }

    public void inserir(Pessoa pessoa) {
        pessoa.setSenha(CriptografiaHelper.getCriptografada(pessoa.getSenha()));
        this.save(pessoa);

    }

    public List<Pessoa> findByCategoriaPessoa (CategoriaPessoaEnum categoriaPessoa) {
        return entityManager.createNamedQuery("Pessoa.findByCategoriaPessoa", Pessoa.class)
                .setParameter("categoriaPessoa", categoriaPessoa)
                .getResultList();
    }



}
