/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.endPoint;


import br.unicap.poo.clinicaMedica.model.Medico;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author Danilo
 */
@ApplicationScoped
public class MedicoJsonToObject {
    private Medico instance;
    
    @JsonCreator
    public MedicoJsonToObject(@JsonProperty("nome") String nome,
                  @JsonProperty("telefone") String telefone) {
        
        instance = new Medico(nome, telefone);
    }
    public Medico getInstance(){
        return instance;
    }
}
