package br.com.codepampa.service;


import br.com.codepampa.model.Pessoa;
import br.com.codepampa.model.Ticket;

import java.util.List;

public class TicketService extends GenericService<Ticket, Long> {

    public List<Ticket> findByPessoa(Pessoa pessoa) {

        //TODO: aqui fazer a logica de buscar os tickets por pessoa, verificar a sua categoria
        //TODO: para assim filtar de forma correta :)_


        return null;
    }
}
