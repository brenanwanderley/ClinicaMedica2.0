/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.endPoint;

import br.unicap.poo.clinicaMedica.model.PlanoDeSaude;
import br.unicap.poo.clinicaMedica.service.SeguradoraPlanoService;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author Lucas Soares
 */
public class PlanoDeSaudeCreateFromJson {
    private PlanoDeSaude planoDeSaude;
    
    public PlanoDeSaudeCreateFromJson(@JsonProperty("seguradoraID")int seguradoraID,
                                      @JsonProperty("numeroCarteira")String numeroCarteira,
                                      @JsonProperty("dataValidade")String dataValidade){
        SeguradoraPlanoService segService = new SeguradoraPlanoService();
        
        planoDeSaude = new PlanoDeSaude(segService.selecionar(seguradoraID), numeroCarteira, dataValidade);
    }
    public PlanoDeSaude getPlanodeSaude(){
        return planoDeSaude;
    }
}
