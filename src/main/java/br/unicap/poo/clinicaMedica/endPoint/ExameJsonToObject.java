/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.endPoint;

import br.unicap.poo.clinicaMedica.model.Consulta;
import br.unicap.poo.clinicaMedica.model.Exame;
import br.unicap.poo.clinicaMedica.model.TipoExame;
import br.unicap.poo.clinicaMedica.model.exceptions.AgendamentoException;
import br.unicap.poo.clinicaMedica.service.ConsultaService;
import br.unicap.poo.clinicaMedica.service.TipoExameService;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;
import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author Danilo
 */
@ApplicationScoped
public class ExameJsonToObject {
    private Exame instance;
    
    @JsonCreator
    public ExameJsonToObject(@JsonProperty("data") Date data, 
                @JsonProperty("consultaID") int consultaId, 
                @JsonProperty("tipoID") int tipoId) throws AgendamentoException{
        ConsultaService conService = new ConsultaService();
        TipoExameService exService = new TipoExameService();
        Consulta consulta = conService.selecionar(consultaId);
        TipoExame tipo = exService.selecionar(tipoId);
        instance = new Exame(data, consulta, tipo);
    }
    public Exame getInstance(){
        return instance;
    }
    
}
