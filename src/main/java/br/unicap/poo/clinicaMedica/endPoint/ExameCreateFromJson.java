/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.endPoint;

import br.unicap.poo.clinicaMedica.model.Exame;
import br.unicap.poo.clinicaMedica.model.exceptions.AgendamentoException;
import br.unicap.poo.clinicaMedica.service.ConsultaService;
import br.unicap.poo.clinicaMedica.service.TipoExameService;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.text.ParseException;
import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author Danilo
 */
@ApplicationScoped
public class ExameCreateFromJson {
    private Exame instance;
    
    @JsonCreator
    public ExameCreateFromJson(@JsonProperty("data") String data, 
                @JsonProperty("consultaID") int consultaId, 
                @JsonProperty("tipoID") int tipoId) throws AgendamentoException, ParseException{
        ConsultaService conService = new ConsultaService();
        TipoExameService exService = new TipoExameService();
        instance = new Exame(data, conService.selecionar(consultaId), exService.selecionar(tipoId));
    }
    public Exame getInstance(){
        return instance;
    }
    
}
