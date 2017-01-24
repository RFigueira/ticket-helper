package br.com.codepampa.service;


import br.com.codepampa.model.Pessoa;
import br.com.codepampa.model.Ticket;

import java.util.Collections;
import java.util.List;

public class TicketService extends GenericService<Ticket, Long> {

    public List<Ticket> findByPessoa(Pessoa pessoa) {

        if(pessoa.getCategoriaPessoaEnum().isSolicitante()) {
            return entityManager.createNamedQuery("Ticket.findTicketsBySolicitante", Ticket.class)
                    .setParameter("solicitante", pessoa)
                    .getResultList();
        } else if(pessoa.getCategoriaPessoaEnum().isUsuarioInterno()) {
            return entityManager.createNamedQuery("Ticket.findTicketsByResponsavel", Ticket.class)
                    .setParameter("responsavel", pessoa)
                    .getResultList();
        } else if(pessoa.getCategoriaPessoaEnum().isPrestadorDeServico()) {
            return entityManager.createNamedQuery("Ticket.findTicketsByTerceirizado", Ticket.class)
                    .setParameter("terceirizado", pessoa)
                    .getResultList();
        }
        return Collections.emptyList();
    }

}
