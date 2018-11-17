/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.endPoint;

import br.unicap.poo.clinicaMedica.model.Exame;
import br.unicap.poo.clinicaMedica.model.Medico;
import br.unicap.poo.clinicaMedica.model.exceptions.AgendamentoException;
import br.unicap.poo.clinicaMedica.iteradores.Iterador;
import javax.ws.rs.Path;
import br.unicap.poo.clinicaMedica.service.ExameService;
import br.unicap.poo.clinicaMedica.service.MedicoService;
import br.unicap.poo.clinicaMedica.service.TipoExameService;
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
@Path("exames")
public class ExameEndPoint {
    private ExameService service;
    private MedicoService medService;
    private TipoExameService tipoService;
    
    public ExameEndPoint(){
        service = new ExameService();
        medService = new MedicoService();
        tipoService = new TipoExameService();
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String listarExames(Medico medico) throws JsonProcessingException{
        return service.verExames(medico).toJson();
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String listarExames(AgendamentoListDateParam exameListDateParam) throws JsonProcessingException{        
        return service.verExames(exameListDateParam.getData()).toJson();
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String listarExames(AgendamentoListDateMedicoParam exameListDateMedicoParam) throws JsonProcessingException{
        return service.verExames(exameListDateMedicoParam.getMedico(), 
                                 exameListDateMedicoParam.getData()).toJson();
    }
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Exame selecionarExame(@PathParam("id") int id){
        Exame item = service.selecionar(id);
        return item;
    }
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void reagendarExame(@PathParam("id") int id, ReagendarParam reagendarParam) throws AgendamentoException, ParseException{
        Exame item = service.selecionar(id);
        item.reagendar(reagendarParam.getData());
    }
    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void cancelarExame(@PathParam("/{id}")int id){
        Exame item = service.selecionar(id);
        
        service.cancelarExame(item);
    }
}
