/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.endPoint;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author aluno
 */
public class ReagendarParam {
    private String data;
    
    @JsonCreator
    public ReagendarParam(@JsonProperty("data") String data){
        this.data=data;
    }
    public String getData(){
        return data;
    }
}
