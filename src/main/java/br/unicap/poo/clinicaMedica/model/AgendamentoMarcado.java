/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.model;

import br.unicap.poo.clinicaMedica.model.exceptions.DataInvalidaException;
import java.text.ParseException;

/**
 *
 * @author aluno
 */
public class AgendamentoMarcado implements StatusAgendamento{
    private static AgendamentoMarcado instance;
    
    private AgendamentoMarcado(){

    }
    public static AgendamentoMarcado getInstance(){
        if(instance==null){
            instance = new AgendamentoMarcado();
        }
        
        return instance;
    }
    @Override
    public void reagendar(String data, Agendamento agendamento) throws DataInvalidaException, ParseException{
        agendamento.setData(data);
    }
    @Override
    public void realizar(Agendamento agendamento){
        agendamento.setStatus(AgendamentoRealizado.getInstance());
        agendamento.getPaciente().increaseNumeroVisitas();
    }
}
