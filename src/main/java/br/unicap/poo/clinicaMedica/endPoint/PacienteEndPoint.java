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

import br.unicap.poo.clinicaMedica.model.Paciente;
import br.unicap.poo.clinicaMedica.model.SeguradoraPlano;
import br.unicap.poo.clinicaMedica.model.exceptions.CepInvalidoException;
import br.unicap.poo.clinicaMedica.model.exceptions.NumeroInvalidoException;
import br.unicap.poo.clinicaMedica.model.exceptions.PessoaException;
import br.unicap.poo.clinicaMedica.model.exceptions.TelefoneInvalidoException;
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
    public Paciente selecionarPaciente(@PathParam("cpf")String cpf){
        return service.selecionar(cpf);
    }
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String novoPaciente(String jsonContent){
        JsonProcessor json = new JsonProcessor(jsonContent);
        try {
            Paciente paciente = new Paciente(json.getJsonParam("cpf"));
            service.cadastrarPaciente(paciente);
        } catch (PessoaException ex) {
            return ex.getMessage();
        }
        return "Paciente adicionado com sucesso";
    }
    /*
    @Path("/{cpf}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String alterarPaciente(@PathParam("cpf")String cpf, String jsonContent){
        JsonProcessor json = new JsonProcessor(jsonContent);
        JsonProcessor jsonEndereco = new JsonProcessor(json.getJsonParam("endereco"));
        JsonProcessor jsonPlanoSaude = new JsonProcessor(json.getJsonParam("planoDeSaude"));
        Paciente selecao = service.selecionar(cpf);
        
        selecao.setNome(json.getJsonParam("nome"));
        try {
            selecao.setTelefone(json.getJsonParam("telefone"));
        } catch (TelefoneInvalidoException ex) {
            return ex.getMessage();
        }
        
        selecao.setDataNasc(json.getJsonParam("data"));
        
        try {
            selecao.getEndereco().setCep(jsonEndereco.getJsonParam("cep"));
        } catch (CepInvalidoException ex) {
            return ex.getMessage();
        }
        selecao.getEndereco().setComplemento(jsonEndereco.getJsonParam("complemento"));
        try {
            selecao.getEndereco().setNumero(Integer.parseInt(jsonEndereco.getJsonParam("numero")));
        } catch (NumeroInvalidoException ex) {
            return ex.getMessage();
        }
        
        selecao.getPlanoDeSaude().setDataValidade(jsonPlanoSaude.getJsonParam("dataValidade"));
        selecao.getPlanoDeSaude().setNumeroCarteira(jsonPlanoSaude.getJsonParam("numeroCarteira"));
        
        SeguradoraPlano seguradora = segService.selecionar(Integer.parseInt(jsonPlanoSaude.getJsonParam("seguradoraPlano")));
        selecao.getPlanoDeSaude().setSeguradoraPlano(seguradora);
        
        return "Paciente alterado com sucesso";
    }
    @Path("/{cpf}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public String removerPaciente(@PathParam("cpf") String cpf){
        Paciente selecao = service.selecionar(cpf);
        if(selecao==null){
            return "Paciente não encontrado";
        }
        service.removerPaciente(selecao);
        
        return "Paciente removido com sucesso";
    }
    */
}
