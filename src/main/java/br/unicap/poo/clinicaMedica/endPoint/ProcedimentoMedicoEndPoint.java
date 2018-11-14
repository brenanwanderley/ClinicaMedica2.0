/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.endPoint;

import br.unicap.poo.clinicaMedica.model.ProcedimentoMedico;
import br.unicap.poo.clinicaMedica.model.Medico;
import br.unicap.poo.clinicaMedica.model.exceptions.AgendamentoException;
import br.unicap.poo.clinicaMedica.iteradores.Iterador;
import javax.ws.rs.Path;
import br.unicap.poo.clinicaMedica.service.ProcedimentoMedicoService;
import br.unicap.poo.clinicaMedica.service.MedicoService;
import br.unicap.poo.clinicaMedica.service.TipoProcedimentoService;
import java.text.ParseException;
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
    private TipoProcedimentoService tipoService;
    
    public ProcedimentoMedicoEndPoint(){
        service = new ProcedimentoMedicoService();
        medService = new MedicoService();
        tipoService = new TipoProcedimentoService();
    }
    @Path("/{medicoid}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Iterador<ProcedimentoMedico> listarProcedimentos(@PathParam("medicoid") int medicoId){
        Medico medico = medService.selecionar(medicoId);
        return service.verProcedimentos(medico);
    }
    @Path("/{dia}/{mes}/{ano}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Iterador<ProcedimentoMedico> listarProcedimentos(AgendamentoListDateParam procedimentoListDateParam){
        
        return service.verProcedimentos(procedimentoListDateParam.getData());
    }
    @Path("/{dia}/{mes}/{ano}/{medicoid}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)

    public Iterador<ProcedimentoMedico> listarProcedimentos(AgendamentoListDateMedicoParam procedimentoListDateMedicoParam){
        return service.verProcedimentos(procedimentoListDateMedicoParam.getMedico(), 
                                        procedimentoListDateMedicoParam.getData());
    }
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public ProcedimentoMedico selecionarProcedimento(@PathParam("id") int id){
        ProcedimentoMedico item = service.selecionar(id);
        return item;
    }
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void alterarProcedimento(@PathParam("id") int id, ReagendarParam reagendarParam) throws AgendamentoException, ParseException{
        ProcedimentoMedico item = service.selecionar(id);
        
        item.reagendar(reagendarParam.getData());
    }
    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void cancelarProcedimento(@PathParam("/{id}")int id){
        ProcedimentoMedico item = service.selecionar(id);
        
        service.cancelarProcedimento(item);
    }
}
