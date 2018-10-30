/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.endPoint;

import br.unicap.poo.clinicaMedica.model.Especialidade;
import br.unicap.poo.clinicaMedica.model.Horario;
import br.unicap.poo.clinicaMedica.model.Medico;
import br.unicap.poo.clinicaMedica.model.SeguradoraPlano;
import br.unicap.poo.clinicaMedica.service.EspecialidadeService;
import br.unicap.poo.clinicaMedica.service.MedicoService;
import br.unicap.poo.clinicaMedica.service.SeguradoraPlanoService;
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

/**
 *
 * @author Danilo
 */
@Path("medico")
public class MedicoEndPoint {
    private MedicoService service;
    private EspecialidadeService espService;
    private SeguradoraPlanoService segService;
    public MedicoEndPoint(){
        service = new MedicoService();
        espService = new EspecialidadeService();
        segService = new SeguradoraPlanoService();
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Medico> listarMedicos(){
        return service.listarMedico();
    }
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void cadastrarMedico(Medico medico) throws Exception{
        Especialidade item = espService.selecionar(medico.getEspecialidadeMedico()
                                                         .getEspecialidades()
                                                         .get(0)
                                                         .getCodigo());
        
        
        
        service.cadastrarMedico(medico);
        
    }
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void alterarMedico(Medico medico){
        Medico item = service.selecionar(medico.getCodigo());
        item.setAll(medico);
        service.alterarMedico(item);
    }
    @Path("/{id}")
    @DELETE
    public void removerMedico(@PathParam("id")int id) throws Exception{
        Medico item = service.selecionar(id);
        if(item==null){
            throw new Exception("Médico não encontrado");
        }
        
        service.removerMedico(item);
    }
    @Path("/{id}/especialidades/{espid}")
    @POST
    public void adicionarEspecialidade(@PathParam("id")int id, @PathParam("espid")int espId) throws Exception{
        Medico item = service.selecionar(id);
        Especialidade espItem;
        
        if(item==null){
            throw new Exception("Médico não encontrado");
        }
        
        espItem = espService.selecionar(espId);
        
        if(espItem==null){
            throw new Exception("Especialidade não encontrada");
        }
        
        item.getEspecialidadeMedico().addEspecialidade(espItem);
    }
    @Path("/{id}/especialidades/{espid}")
    @DELETE
    public void removerEspecialidade(@PathParam("id")int id, @PathParam("espid")int espId) throws Exception{
        Medico item = service.selecionar(id);
        Especialidade espItem;
        
        if(item==null){
            throw new Exception("Médico não encontrado");
        }
        
        espItem = espService.selecionar(espId);
        
        if(espItem==null){
            throw new Exception("Especialidade não encontrada");
        }
        
        item.getEspecialidadeMedico().removeEspecialidade(espItem);
    }
    @Path("/{id}/horarios")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void adicionarHorario(@PathParam("id")int id, Horario horario) throws Exception{
        Medico item = service.selecionar(id);
        
        if(item==null){
            throw new Exception("Médico não encontrado");
        }
        
        item.getHorarioMedico().addHorario(horario);  
    }
    @Path("/{id}/horarios/{horarioid}")
    @DELETE
    public void removerHorario(@PathParam("id")int id, @PathParam("horarioid") int horarioId) throws Exception{
        Medico item = service.selecionar(id);
        Horario horItem;
        
        if(item==null){
            throw new Exception("Médico não encontrado");
        }
        
        horItem = item.getHorarioMedico().selecionar(horarioId);

        item.getHorarioMedico().removeHorario(horItem);
    }
    @Path("/{id}/seguradora/{segid}")
    @POST
    public void adicionarSeguradora(@PathParam("id")int id, @PathParam("segId") int segId) throws Exception{
        Medico item = service.selecionar(id);
        SeguradoraPlano segItem;
        
        if(item==null){
            throw new Exception("Médico não encontrado");
        }
        
        segItem = segService.selecionar(segId);
        
        if(segItem==null){
            throw new Exception("Seguradora não encontrada");            
        }
        
        item.getPlanoSaudeMedico().adicionarSeguradora(segItem);
    }
    @Path("/{id}/seguradora/{segid}")
    @DELETE
    public void removerSeguradora(@PathParam("id")int id, @PathParam("segId") int segId) throws Exception{
        Medico item = service.selecionar(id);
        SeguradoraPlano segItem;
        
        if(item==null){
            throw new Exception("Médico não encontrado");
        }
        
        segItem = segService.selecionar(segId);
        
        if(segItem==null){
            throw new Exception("Seguradora não encontrada");            
        }
        item.getPlanoSaudeMedico().adicionarSeguradora(segItem);
    }
    
}
