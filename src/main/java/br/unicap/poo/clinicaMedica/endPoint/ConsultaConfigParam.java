/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.endPoint;

import br.unicap.poo.clinicaMedica.repository.ConsultaRepEnum;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author Danilo
 */
public class ConsultaConfigParam {
    private ConsultaRepEnum consultaRepEnum;
    
    @JsonCreator
    public ConsultaConfigParam(@JsonProperty("consultaRepEnum")ConsultaRepEnum consultaRepEnum){
        this.consultaRepEnum=consultaRepEnum;
    }
    
    public ConsultaRepEnum getConsultaEnum(){
        return consultaRepEnum;
    }
}
