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

import br.unicap.poo.clinicaMedica.model.Consulta;
import br.unicap.poo.clinicaMedica.model.Medico;
import br.unicap.poo.clinicaMedica.model.Paciente;
import br.unicap.poo.clinicaMedica.service.ConsultaService;
import br.unicap.poo.clinicaMedica.service.ExameService;
import br.unicap.poo.clinicaMedica.service.MedicoService;
import br.unicap.poo.clinicaMedica.service.PacienteService;
import br.unicap.poo.clinicaMedica.service.ProcedimentoMedicoService;
import java.util.Calendar;
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

@Path("consulta")
public class ConsultaEndPoint {
    private ConsultaService service;
    private ExameService exService;
    private ProcedimentoMedicoService procService;
    private PacienteService pacService;
    private MedicoService medService;
    
    public ConsultaEndPoint(){
        service = new ConsultaService();
        exService = new ExameService();
        procService = new ProcedimentoMedicoService();
        pacService = new PacienteService();
        medService = new MedicoService();
    }
    
    @Path("/{medicoid}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Consulta> listarConsultas(@PathParam("medicoid") int medicoId){
        Medico medico = medService.selecionar(medicoId);
        return service.verConsultas(medico);
    }
    @Path("/{dia}/{mes}/{ano}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Consulta> listarConsultas(@PathParam("dia")int dia, @PathParam("mes")int mes, @PathParam("ano")int ano){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, dia);
        calendar.set(Calendar.MONTH, mes-1);
        calendar.set(Calendar.YEAR, ano);
        
        return service.verConsultas(calendar.getTime());
    }
    @Path("/{dia}/{mes}/{ano}/{medicoid}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)

    public List<Consulta> listarConsultas(@PathParam("dia")int dia, 
                                          @PathParam("mes")int mes, 
                                          @PathParam("ano")int ano, 
                                          @PathParam("medicoid") int medicoId){
        Medico medico = medService.selecionar(medicoId);
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, dia);
        calendar.set(Calendar.MONTH, mes-1);
        calendar.set(Calendar.YEAR, ano);
        
        return service.verConsultas(medico, calendar.getTime());
    }
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void novaConsulta(Consulta consulta){
        Medico medico = medService.selecionar(consulta.getMedico().getCodigo());
        Paciente paciente = pacService.selecionar(consulta.getPaciente().getCpf());
        
        consulta.s
        
    }

        
}
