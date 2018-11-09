/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.endPoint;

/**
 *
 * @author Danilo
 */

import br.unicap.poo.clinicaMedica.model.TipoProcedimento;
import br.unicap.poo.clinicaMedica.repository.Iterador;
import br.unicap.poo.clinicaMedica.service.TipoProcedimentoService;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("tipoprocedimento")
public class TipoProcedimentoEndPoint {
    TipoProcedimentoService service;
    public TipoProcedimentoEndPoint(){
        service =  new TipoProcedimentoService();
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Iterador<TipoProcedimento> listarTipoProcedimentos(){
        return service.listar();
    }
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void cadastrarTipoProcedimento(TipoProcedimento tipoProcedimento){
        service.alterarTipoProcedimento(tipoProcedimento);
    }
    @Path("/{id}")
    @DELETE
    public void removerTipoProcedimento(@PathParam("id") int id){
        TipoProcedimento item = service.selecionar(id);
        service.removerTipoProcedimento(item);
    }
    @Path("/{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void alterarTipoProcedimento(@PathParam("id") int id, String jsonContent){
        TipoProcedimento item = service.selecionar(id);
        item.setAll(jsonContent);
        service.alterarTipoProcedimento(item);
    }
    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public TipoProcedimento selecionarTipoProcedimento(@PathParam("id") int id){
        return service.selecionar(id);
    }
}
