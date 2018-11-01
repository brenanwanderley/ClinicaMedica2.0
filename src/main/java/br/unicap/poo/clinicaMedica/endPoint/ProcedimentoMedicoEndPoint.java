/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.endPoint;

import br.unicap.poo.clinicaMedica.model.ProcedimentoMedico;
import br.unicap.poo.clinicaMedica.model.Medico;
import javax.ws.rs.Path;
import br.unicap.poo.clinicaMedica.service.ProcedimentoMedicoService;
import br.unicap.poo.clinicaMedica.service.MedicoService;
import java.util.Calendar;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Lucas Soares
 */
@Path("procedimentomedico")
public class ProcedimentoMedicoEndPoint {
    private ProcedimentoMedicoService service;
    private MedicoService medService;
    
    public ProcedimentoMedicoEndPoint(){
        service = new ProcedimentoMedicoService();
    }
    @Path("/{medicoid}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<ProcedimentoMedico> listarProcedimentos(@PathParam("medicoid") int medicoId){
        Medico medico = medService.selecionar(medicoId);
        return service.verProcedimentos(medico);
    }
    @Path("/{dia}/{mes}/{ano}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<ProcedimentoMedico> listarProcedimentos(@PathParam("dia")int dia, @PathParam("mes")int mes, @PathParam("ano")int ano){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, dia);
        calendar.set(Calendar.MONTH, mes-1);
        calendar.set(Calendar.YEAR, ano);
        
        return service.verProcedimentos(calendar.getTime());
    }
    @Path("/{dia}/{mes}/{ano}/{medicoid}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)

    public List<ProcedimentoMedico> listarProcedimentos(@PathParam("dia")int dia, 
                                          @PathParam("mes")int mes, 
                                          @PathParam("ano")int ano, 
                                          @PathParam("medicoid") int medicoId){
        Medico medico = medService.selecionar(medicoId);
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, dia);
        calendar.set(Calendar.MONTH, mes-1);
        calendar.set(Calendar.YEAR, ano);
        
        return service.verProcedimentos(medico, calendar.getTime());
    }
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public ProcedimentoMedico selecionarProcedimento(@PathParam("id") int id){
        ProcedimentoMedico item = service.selecionar(id);
        return item;
    }
    @Path("/{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void alterarExame(@PathParam("id") int id, ProcedimentoMedicoJsonToObject exameJson){
        ProcedimentoMedico alteracao = exameJson.getInstance();
        ProcedimentoMedico item = service.selecionar(id);
        
        item.setAll(alteracao);
        
        service.alterarProcedimento(item);
    }
    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void cancelarExame(@PathParam("/{id}")int id){
        ProcedimentoMedico item = service.selecionar(id);
        
        service.cancelarProcedimento(item);
    }
}
