/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.endPoint;

import br.unicap.poo.clinicaMedica.model.PlanoDeSaude;
import br.unicap.poo.clinicaMedica.model.SeguradoraPlano;
import br.unicap.poo.clinicaMedica.service.SeguradoraPlanoService;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author Danilo
 */
@ApplicationScoped
public class PlanoDeSaudeJsonToObject {
    private PlanoDeSaude instance;
    
    @JsonCreator
    public PlanoDeSaudeJsonToObject(@JsonProperty("seguradoraPlanoID")int seguradoraPlanoId, 
                        @JsonProperty("numeroCarteira")String numeroCarteira,
                        @JsonProperty("dataValidade")String dataValidade){
        SeguradoraPlanoService segService = new SeguradoraPlanoService();
        SeguradoraPlano seguradora = segService.selecionar(seguradoraPlanoId);
        
        instance = new PlanoDeSaude(seguradora, numeroCarteira, dataValidade);
    }
    public PlanoDeSaude getInstance(){
        return instance;
    }
}
