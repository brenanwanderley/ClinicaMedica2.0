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
import br.unicap.poo.clinicaMedica.model.Exame;
import br.unicap.poo.clinicaMedica.model.Medico;
import br.unicap.poo.clinicaMedica.model.ProcedimentoMedico;
import br.unicap.poo.clinicaMedica.model.exceptions.AgendamentoException;
import br.unicap.poo.clinicaMedica.iteradores.Iterador;
import br.unicap.poo.clinicaMedica.service.ConsultaService;
import br.unicap.poo.clinicaMedica.service.ExameService;
import br.unicap.poo.clinicaMedica.service.MedicoService;
import br.unicap.poo.clinicaMedica.service.PacienteService;
import br.unicap.poo.clinicaMedica.service.ProcedimentoMedicoService;
import java.text.ParseException;
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
    public Iterador<Consulta> listarConsultas(@PathParam("medicoid") int medicoId){
        Medico medico = medService.selecionar(medicoId);
        return service.verConsultas(medico);
    }
    @Path("/{dia}/{mes}/{ano}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Iterador<Consulta> listarConsultas(AgendamentoListDateParam consultaListDateParam){
        return service.verConsultas(consultaListDateParam.getData());
    }
    @Path("/{dia}/{mes}/{ano}/{medicoid}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)

    public Iterador<Consulta> listarConsultas(AgendamentoListDateMedicoParam consultaListDateMedicoParam){
        return service.verConsultas(consultaListDateMedicoParam.getMedico(), 
                                    consultaListDateMedicoParam.getData());
    }
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void novaConsulta(ConsultaDirector consultaDirector){
        service.AgendarConsulta(consultaDirector.getConsulta());
    }
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void reagendarConsulta(@PathParam("id")int id, ReagendarParam reagendarParam) throws ParseException, AgendamentoException{
        Consulta consulta = service.selecionar(id);
        consulta.reagendar(reagendarParam.getData());
        
        service.alterarConsulta(consulta);
    }
    @DELETE
    @Path("/{id}")
    public void removerConsulta(@PathParam("id") int id){
        Consulta item = service.selecionar(id);
        
        service.cancelarConsulta(item);
    }
    @GET
    @Path("/{id}")
    public Consulta selecionarConsulta(@PathParam("id")int id){
        return service.selecionar(id);
    }
    @POST
    @Path("/novoexame")
    @Consumes(MediaType.APPLICATION_JSON)
    public void novoExame(Exame exame){
        exService.novoExame(exame);
    }
    @POST
    @Path("/novoprocedimento")
    @Consumes(MediaType.APPLICATION_JSON)
    public void novoProcedimento(ProcedimentoMedico procedimentoMedico){
        procService.agendarProcedimento(procedimentoMedico);
    }
}
