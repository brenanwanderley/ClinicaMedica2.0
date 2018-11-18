/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.endPoint;

import br.unicap.poo.clinicaMedica.model.Medico;
import br.unicap.poo.clinicaMedica.model.exceptions.PessoaException;
import br.unicap.poo.clinicaMedica.service.MedicoService;
import com.fasterxml.jackson.core.JsonProcessingException;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Danilo
 */
@Path("medico")
public class MedicoEndPoint {
    private MedicoService service;
    public MedicoEndPoint(){
        service = new MedicoService();
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String listarMedicos() throws JsonProcessingException{
        return service.listarMedico().toJson();
    }
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void cadastrarMedico(Medico medico){
        service.cadastrarMedico(medico);
    }
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void alterarMedico(Medico medico) throws PessoaException{
        service.alterarMedico(medico);
    }
    @Path("/{id}")
    @DELETE
    public void removerMedico(@PathParam("id")int id) throws Exception{
        Medico item = service.selecionar(id);
        
        service.removerMedico(item);
    }
}
