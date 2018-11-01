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

import br.unicap.poo.clinicaMedica.auxClasses.JsonProcessor;
import br.unicap.poo.clinicaMedica.model.Paciente;
import br.unicap.poo.clinicaMedica.model.SeguradoraPlano;
import br.unicap.poo.clinicaMedica.model.exceptions.PessoaException;
import br.unicap.poo.clinicaMedica.service.PacienteService;
import br.unicap.poo.clinicaMedica.service.SeguradoraPlanoService;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("paciente")
public class PacienteEndPoint {
    private PacienteService service;
    private SeguradoraPlanoService segService;
    public PacienteEndPoint(){
        service = new PacienteService();
        segService = new SeguradoraPlanoService();
    }
    
    @Path("/{cpf}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Paciente selecionarPaciente(@PathParam("cpf") String cpf){
        return service.selecionar(cpf);
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void cadastrarPaciente(Paciente paciente){
        service.cadastrarPaciente(paciente);
        
    }
    @Path("/{cpf}")
    @DELETE
    public void removerPaciente(@PathParam("cpf") String cpf){
        Paciente item = service.selecionar(cpf);
        service.removerPaciente(item);
    }
    @Path("/{cpf}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void alterarPaciente(@PathParam("cpf")String cpf, String jsonContent) throws PessoaException{
        Paciente alteracao = service.selecionar(cpf);
        JsonProcessor json = new JsonProcessor(jsonContent);
        SeguradoraPlano seguradora = segService.selecionar(Integer.parseInt(json.getJsonParam("seguradoraPlanoID")));
        
        alteracao.setAll(jsonContent, seguradora);
        
        service.alterarPaciente(alteracao);
    }
}
