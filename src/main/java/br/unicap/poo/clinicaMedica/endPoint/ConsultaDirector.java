/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.endPoint;

import br.unicap.poo.clinicaMedica.model.Consulta;
import br.unicap.poo.clinicaMedica.model.ConsultaBuilder;
import br.unicap.poo.clinicaMedica.model.Medico;
import br.unicap.poo.clinicaMedica.model.Paciente;
import br.unicap.poo.clinicaMedica.model.exceptions.ConsultaException;
import br.unicap.poo.clinicaMedica.model.exceptions.DataInvalidaException;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.text.ParseException;

/**
 *
 * @author aluno
 */
public class ConsultaDirector {
    private Consulta consulta;
    
    @JsonCreator
    public ConsultaDirector(@JsonProperty("data") String data,
                            @JsonProperty("medico") Medico medico,
                            @JsonProperty("paciente") Paciente paciente) throws DataInvalidaException, ConsultaException, ParseException{
        ConsultaBuilder builder = new ConsultaBuilder();
        consulta = builder.addData(data)
                         .addMedico(medico)
                         .addPaciente(paciente)
                         .build();
    
    }
    public Consulta getConsulta(){
        return consulta;
    }
}
