/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.endPoint;

import br.unicap.poo.clinicaMedica.model.Endereco;
import br.unicap.poo.clinicaMedica.model.Paciente;
import br.unicap.poo.clinicaMedica.model.PlanoDeSaude;
import br.unicap.poo.clinicaMedica.model.SeguradoraPlano;
import br.unicap.poo.clinicaMedica.model.exceptions.PessoaException;
import br.unicap.poo.clinicaMedica.service.SeguradoraPlanoService;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author Danilo
 */
@ApplicationScoped
public class PacienteJsonToObject {
    private Paciente instance;
    @JsonCreator
    public PacienteJsonToObject(@JsonProperty("nome") String nome,
                    @JsonProperty("telefone") String telefone, 
                    @JsonProperty("cpf") String cpf, 
                    @JsonProperty("planoDeSaude") PlanoDeSaude planoDeSaude, 
                    @JsonProperty("endereco") Endereco endereco,
                    @JsonProperty("dataNasc") String dataNasc) throws PessoaException{
        
        SeguradoraPlanoService segService = new SeguradoraPlanoService();
        SeguradoraPlano item = planoDeSaude.getSeguradoraPlano();
        SeguradoraPlano segRef=null;
        
        if(item!=null){
            segRef = segService.selecionar(item.getCodigo());
        }
        
        planoDeSaude.setSeguradoraPlano(segRef);
        instance = new Paciente(nome, telefone, cpf);
        instance.getPlanoDeSaude().setAll(planoDeSaude);
    }
    public Paciente getInstance(){
        return instance;
    }
}
