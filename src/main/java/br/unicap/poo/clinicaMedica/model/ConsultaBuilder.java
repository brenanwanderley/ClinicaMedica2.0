/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.model;

import br.unicap.poo.clinicaMedica.model.exceptions.ConsultaException;
import br.unicap.poo.clinicaMedica.model.exceptions.DataInvalidaException;

/**
 *
 * @author Lucas Soares
 */
public class ConsultaBuilder{
    private Consulta consulta;
    
    public ConsultaBuilder(){
        consulta = new Consulta();
    }
    public ConsultaBuilder addData(String data) throws DataInvalidaException{
        consulta.setData(data);
        return this;
    }
    public ConsultaBuilder addHora(String hora) throws DataInvalidaException{
        consulta.setHora(hora);
        return this;
    }
    public ConsultaBuilder addMedico(Medico medico) throws ConsultaException{
        consulta.setMedico(medico);
        return this;
    }
    public ConsultaBuilder addPaciente(Paciente paciente) throws ConsultaException{
        consulta.setPaciente(paciente);
        return this;
    }
    public Consulta build() throws ConsultaException{
        if(consulta.getMedico()==null){
            throw new ConsultaException("Consulta sem médico definido");
        }
        if(consulta.getPaciente()==null){
            throw new ConsultaException("Consulta sem paciente definido");
        }
        
        return consulta;
    }
    
}
