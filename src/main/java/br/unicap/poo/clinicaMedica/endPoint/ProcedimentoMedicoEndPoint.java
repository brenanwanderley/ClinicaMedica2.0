/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.endPoint;

import br.unicap.poo.clinicaMedica.model.Consulta;
import br.unicap.poo.clinicaMedica.model.ProcedimentoMedico;
import br.unicap.poo.clinicaMedica.model.Medico;
import br.unicap.poo.clinicaMedica.model.exceptions.AgendamentoException;
import javax.ws.rs.Path;
import br.unicap.poo.clinicaMedica.service.ProcedimentoMedicoService;
import br.unicap.poo.clinicaMedica.service.MedicoService;
import br.unicap.poo.clinicaMedica.service.TipoProcedimentoService;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.text.ParseException;
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
    @Path("/listarpormedico")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String listarProcedimentos(Medico medico) throws JsonProcessingException{
        return service.verProcedimentos(medico).toJson();
    }
    @Path("/listarpordata")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String listarProcedimentos(AgendamentoListDateParam procedimentoListDateParam) throws JsonProcessingException{
        
        return service.verProcedimentos(procedimentoListDateParam.getData()).toJson();
    }
    @Path("/listarpordatamedico")
    @GET
    @Produces(MediaType.APPLICATION_JSON)

    public String listarProcedimentos(AgendamentoListDateMedicoParam procedimentoListDateMedicoParam) throws JsonProcessingException{
        return service.verProcedimentos(procedimentoListDateMedicoParam.getMedico(), 
                                        procedimentoListDateMedicoParam.getData()).toJson();
    }
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public ProcedimentoMedico selecionarProcedimento(@PathParam("id") int id){
        ProcedimentoMedico item = service.selecionar(id);
        return item;
    }
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void alterarProcedimento(ReagendarParam reagendarParam) throws AgendamentoException, ParseException{
        ProcedimentoMedico item = service.selecionar(reagendarParam.getCodigo());
        
        item.reagendar(reagendarParam.getData());
    }
    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void cancelarProcedimento(@PathParam("/{id}")int id){
        ProcedimentoMedico item = service.selecionar(id);
        
        service.cancelarProcedimento(item);
    }
    @PUT
    @Path("/realizarprocedimento/{id}")
    public void realizarProcedimento(@PathParam("id") int id) throws AgendamentoException{
        ProcedimentoMedico item = service.selecionar(id);
        item.realizar();
        service.alterarProcedimento(item);
    }
    @GET
    @Path("/{id}/consulta")
    @Produces(MediaType.APPLICATION_JSON)
    public Consulta getConsulta(@PathParam("id") int id){
        return service.selecionar(id).getConsulta();
    }
}
