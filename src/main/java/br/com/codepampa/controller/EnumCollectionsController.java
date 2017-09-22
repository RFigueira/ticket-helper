package br.com.codepampa.controller;

import br.com.codepampa.enumerator.CategoriaContatoEnum;
import br.com.codepampa.enumerator.CategoriaEnum;
import br.com.codepampa.enumerator.CategoriaPessoaEnum;
import br.com.codepampa.enumerator.PrioridadeEnum;
import br.com.codepampa.enumerator.StatusEnum;
import br.com.codepampa.enumerator.StatusTicketEnum;
import lombok.Getter;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.util.List;

import static java.util.Arrays.asList;

@Getter
@ManagedBean
@ApplicationScoped
public class EnumCollectionsController {

        private final List<StatusEnum> statusEnumList = asList(StatusEnum.values());
        private final List<CategoriaEnum> categoriaEnumList = asList(CategoriaEnum.values());
        private final List<CategoriaContatoEnum> categoriaContatoEnumList = asList(CategoriaContatoEnum.values());
        private final List<CategoriaPessoaEnum> categoriaPessoaEnum = asList(CategoriaPessoaEnum.values());
        private final List<PrioridadeEnum> prioridadeEnumList = asList(PrioridadeEnum.values());
        private final List<StatusTicketEnum> statusTicketEnumList = asList(StatusTicketEnum.values());
}
