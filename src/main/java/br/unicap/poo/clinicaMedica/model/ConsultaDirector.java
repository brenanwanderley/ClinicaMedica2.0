/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.model;

import br.unicap.poo.clinicaMedica.model.exceptions.ConsultaException;
import br.unicap.poo.clinicaMedica.model.exceptions.DataInvalidaException;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.text.ParseException;
import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author aluno
 */
@ApplicationScoped
public class ConsultaDirector {
    private Consulta consulta;
    
    @JsonCreator
    public ConsultaDirector(@JsonProperty("codigo") int codigo,
                            @JsonProperty("data") String data,
                            @JsonProperty("medico") Medico medico,
                            @JsonProperty("paciente") Paciente paciente) throws DataInvalidaException, ConsultaException, ParseException{
        ConsultaBuilder builder = new ConsultaBuilder();
        consulta = builder.addCodigo(codigo)
                         .addPaciente(paciente)
                         .addData(data)
                         .addMedico(medico)
                         .build();
    
    }
    public Consulta getConsulta(){
        return consulta;
    }
}
