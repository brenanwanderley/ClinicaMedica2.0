/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.endPoint;
import br.unicap.poo.clinicaMedica.model.Especialidade;
import br.unicap.poo.clinicaMedica.repository.Iterador;
import javax.ws.rs.PathParam;
import br.unicap.poo.clinicaMedica.service.EspecialidadeService;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Danilo
 */
@Path("especialidade")
public class EspecialidadeEndPoint {
    EspecialidadeService service;
    public EspecialidadeEndPoint(){
        service = new EspecialidadeService();
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Iterador<Especialidade> listarEspecialidades(){
        return service.listar();
    }
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void cadastrarEspecialidade(Especialidade especialidade){
        service.inserirEspecialidade(especialidade);
    }
    @Path("/{id}")
    @DELETE
    public void removerEspecialidade(@PathParam("id") int id){
        Especialidade item = service.selecionar(id);
        service.removerEspecialidade(item);
    }
    @Path("/{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void alterarEspecialidade(@PathParam("id") int id, String jsonContent){
        Especialidade item = service.selecionar(id);
        item.setAll(jsonContent);
        service.alterarEspecialidade(item); 
    }
    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Especialidade selecionarEspecialidade(@PathParam("id")int id){
        return service.selecionar(id);
    }
    
}
