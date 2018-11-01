/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.endPoint;

import br.unicap.poo.clinicaMedica.model.Consulta;
import br.unicap.poo.clinicaMedica.model.Medico;
import br.unicap.poo.clinicaMedica.model.Paciente;
import br.unicap.poo.clinicaMedica.model.exceptions.AgendamentoException;
import br.unicap.poo.clinicaMedica.service.MedicoService;
import br.unicap.poo.clinicaMedica.service.PacienteService;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;
import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author Danilo
 */
@ApplicationScoped
public class ConsultaJsonToObject {
    private Consulta instance;
    
    @JsonCreator
    public ConsultaJsonToObject(@JsonProperty("data")String data, 
                    @JsonProperty("medicoID")int medicoId, 
                    @JsonProperty("pacienteCPF")String pacienteCpf) throws AgendamentoException{
        MedicoService medService = new MedicoService();
        PacienteService pacService = new PacienteService();
        Paciente paciente = pacService.selecionar(pacienteCpf);
        Medico medico = medService.selecionar(medicoId);
        instance = new Consulta(data, medico, paciente);
    }
    
    public Consulta getInstance(){
        return instance;
    }
}
