package br.com.codepampa.rest;

import br.com.codepampa.model.Categoria;
import br.com.codepampa.service.CategoriaService;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/api")
public class RestApplication {


   private CategoriaService categoriaService;

    public RestApplication() {
        categoriaService = new CategoriaService();
    }


    @GET
    @Path("/categoria")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Categoria> listarClientes() {
        return  categoriaService.findAllCriteria();
    }




}
