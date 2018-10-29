/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.endPoint;

import br.unicap.poo.clinicaMedica.model.Consulta;
import br.unicap.poo.clinicaMedica.model.Exame;
import br.unicap.poo.clinicaMedica.model.Medico;
import javax.ws.rs.Path;
import br.unicap.poo.clinicaMedica.service.ExameService;
import br.unicap.poo.clinicaMedica.service.MedicoService;
import java.util.Calendar;
import java.util.List;
import javax.ws.rs.GET;
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
    
    public ExameEndPoint(){
        service = new ExameService();
    }
       @Path("/{medicoid}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Exame> listarExames(@PathParam("medicoid") int medicoId){
        Medico medico = medService.selecionar(medicoId);
        return service.verExames(medico);
    }
    @Path("/{dia}/{mes}/{ano}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Exame> listarExames(@PathParam("dia")int dia, @PathParam("mes")int mes, @PathParam("ano")int ano){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, dia);
        calendar.set(Calendar.MONTH, mes-1);
        calendar.set(Calendar.YEAR, ano);
        
        return service.verExames(calendar.getTime());
    }
    @Path("/{dia}/{mes}/{ano}/{medicoid}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)

    public List<Exame> listarExames(@PathParam("dia")int dia, 
                                          @PathParam("mes")int mes, 
                                          @PathParam("ano")int ano, 
                                          @PathParam("medicoid") int medicoId){
        Medico medico = medService.selecionar(medicoId);
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, dia);
        calendar.set(Calendar.MONTH, mes-1);
        calendar.set(Calendar.YEAR, ano);
        
        return service.verExames(medico, calendar.getTime());
    }
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Exame selecionarExame(@PathParam("id") int id){
        
    }
    
    
    
}
