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
import br.unicap.poo.clinicaMedica.model.exceptions.EspecialidadeMedicoNaoEncontradaException;
import br.unicap.poo.clinicaMedica.model.exceptions.EspecialidadeMedicoRepetidaException;
import br.unicap.poo.clinicaMedica.model.exceptions.MedicoSemEspecialidadeException;
import br.unicap.poo.clinicaMedica.model.exceptions.PessoaException;
import br.unicap.poo.clinicaMedica.repository.Iterador;
import br.unicap.poo.clinicaMedica.service.EspecialidadeService;
import br.unicap.poo.clinicaMedica.service.MedicoService;
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
    public Iterador<Medico> listarMedicos(){
        return service.listarMedico();
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
    @Path("/{id}/especialidades/{espid}")
    @POST
    public void adicionarEspecialidade(@PathParam("id")int id, @PathParam("espid")int espId) throws EspecialidadeMedicoRepetidaException{
        Medico item = service.selecionar(id);
        Especialidade espItem;
        
        espItem = espService.selecionar(espId);
        
        item.getEspecialidadeMedico().addEspecialidade(espItem);
    }
    @Path("/{id}/especialidades/{espid}")
    @DELETE
    public void removerEspecialidade(@PathParam("id")int id, @PathParam("espid")int espId) throws EspecialidadeMedicoNaoEncontradaException, MedicoSemEspecialidadeException{
        Medico item = service.selecionar(id);
        Especialidade espItem;
        
        espItem = espService.selecionar(espId);

        item.getEspecialidadeMedico().removeEspecialidade(espItem);
    }
    @Path("/{id}/horarios")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void adicionarHorario(@PathParam("id")int id, Horario horario) throws Exception{
        Medico item = service.selecionar(id);
        
        item.getHorarioMedico().addHorario(horario);  
    }
    @Path("/{id}/horarios/{horarioid}")
    @DELETE
    public void removerHorario(@PathParam("id")int id, @PathParam("horarioid") int horarioId) throws Exception{
        Medico item = service.selecionar(id);
        Horario horItem;
        
        horItem = item.getHorarioMedico().selecionar(horarioId);

        item.getHorarioMedico().removeHorario(horItem);
    }
    @Path("/{id}/seguradora/{segid}")
    @POST
    public void adicionarSeguradora(@PathParam("id")int id, @PathParam("segid") int segId) throws Exception{
        Medico item = service.selecionar(id);
        SeguradoraPlano segItem;
        
        segItem = segService.selecionar(segId);
        
        item.getPlanoSaudeMedico().adicionarSeguradora(segItem);
    }
    @Path("/{id}/seguradora/{segid}")
    @DELETE
    public void removerSeguradora(@PathParam("id")int id, @PathParam("segid") int segId) throws Exception{
        Medico item = service.selecionar(id);
        SeguradoraPlano segItem;
        
        segItem = segService.selecionar(segId);

        item.getPlanoSaudeMedico().adicionarSeguradora(segItem);
    }
    
}
