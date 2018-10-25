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

import br.unicap.poo.clinicaMedica.model.SeguradoraPlano;
import br.unicap.poo.clinicaMedica.service.SeguradoraPlanoService;
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

@Path("seguradoraplano")
public class SeguradoraPlanoEndPoint {
    SeguradoraPlanoService service;

    public SeguradoraPlanoEndPoint(){
        service = new SeguradoraPlanoService();
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<SeguradoraPlano> listarSeguradoraPlanos(){
        return service.listarSeguradoras();
    }
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void cadastrarSeguradoraPlano(SeguradoraPlano seguradora){
        service.inserirSeguradora(seguradora);
    }
    @Path("/{id}")
    @DELETE
    public void removerSeguradoraPlano(@PathParam("id") int id){
        SeguradoraPlano item = service.selecionar(id);
        service.removerSeguradora(item);
    }
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void alterarSeguradoraPlano(SeguradoraPlano seguradora){
        SeguradoraPlano item = service.selecionar(seguradora.getCodigo());
        item.setAll(seguradora);
        service.alterarSeguradora(item);
    }
    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public SeguradoraPlano selecionarSeguradoraPlano(@PathParam("id")int id){
        return service.selecionar(id);
    }   
}
