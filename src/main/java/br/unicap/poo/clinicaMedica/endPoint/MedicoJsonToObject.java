/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.endPoint;

import br.unicap.poo.clinicaMedica.model.Especialidade;
import br.unicap.poo.clinicaMedica.model.EspecialidadeMedico;
import br.unicap.poo.clinicaMedica.model.Horario;
import br.unicap.poo.clinicaMedica.model.HorarioMedico;
import br.unicap.poo.clinicaMedica.model.Medico;
import br.unicap.poo.clinicaMedica.model.PlanoSaudeMedico;
import br.unicap.poo.clinicaMedica.service.EspecialidadeService;
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
                  @JsonProperty("telefone") String telefone, 
                  @JsonProperty("horario") Horario horario, 
                  @JsonProperty("especialidadeId")int especialidadeId) {
        EspecialidadeService espService = new EspecialidadeService();
        Especialidade especialidade = espService.selecionar(especialidadeId);
        
        instance = new Medico(nome, telefone, horario, especialidade);
    }
    public Medico getInstance(){
        return instance;
    }
}
