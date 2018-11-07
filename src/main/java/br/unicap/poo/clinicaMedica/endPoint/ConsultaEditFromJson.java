/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.endPoint;

import br.unicap.poo.clinicaMedica.model.Consulta;
import br.unicap.poo.clinicaMedica.model.exceptions.AgendamentoException;
import br.unicap.poo.clinicaMedica.service.ConsultaService;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author Lucas Soares
 */
public class ConsultaEditFromJson {
    private Consulta edit;
    
    @JsonCreator
    public ConsultaEditFromJson(@JsonProperty("id") int id,
                                @JsonProperty("data") String data, 
                                @JsonProperty("hora") String hora) throws AgendamentoException{
        ConsultaService service = new ConsultaService();
        edit = service.selecionar(id);
        edit.setData(data);
        edit.setHora(hora);
    }
    public Consulta getEdit(){
        return edit;
    }
}
