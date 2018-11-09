/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.endPoint;

import br.unicap.poo.clinicaMedica.model.Consulta;
import br.unicap.poo.clinicaMedica.model.ConsultaBuilder;
import br.unicap.poo.clinicaMedica.model.Paciente;
import br.unicap.poo.clinicaMedica.model.exceptions.AgendamentoException;
import br.unicap.poo.clinicaMedica.model.exceptions.DataInvalidaException;
import br.unicap.poo.clinicaMedica.service.MedicoService;
import br.unicap.poo.clinicaMedica.service.PacienteService;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.text.ParseException;
import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author Danilo
 */
@ApplicationScoped
public class ConsultaCreateFromJson {
    private Consulta instance;
    
    @JsonCreator
    public ConsultaCreateFromJson(@JsonProperty("data")String data,
                    @JsonProperty("hora") String hora,
                    @JsonProperty("medicoID")int medicoId, 
                    @JsonProperty("pacienteCPF")String pacienteCpf) throws AgendamentoException, DataInvalidaException, ParseException{
        ConsultaBuilder builder = new ConsultaBuilder();
        MedicoService medService = new MedicoService();
        PacienteService pacService = new PacienteService();
        Paciente paciente = pacService.selecionar(pacienteCpf);
        
        instance = builder.addData(data)
                            .addMedico(medService.selecionar(medicoId))
                            .addPaciente(pacService.selecionar(pacienteCpf))
                            .build();
    }
    
    public Consulta getInstance(){
        return instance;
    }
}
