/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.model;

import br.unicap.poo.clinicaMedica.model.exceptions.AgendamentoException;
import java.text.ParseException;

/**
 *
 * @author aluno
 */
public class AgendamentoRealizado implements StatusAgendamento{
    private static AgendamentoRealizado instance;
    
    private AgendamentoRealizado(){

    }
    public static AgendamentoRealizado getInstance(){
        if(instance==null){
            instance = new AgendamentoRealizado();
        }
        
        return instance;
    }
    @Override
    public void reagendar(String data, Agendamento agendamento) throws AgendamentoException, ParseException{
        throw new AgendamentoException("O agendamento já foi realizado");
    }
    @Override
    public void realizar(Agendamento agendamento){
        agendamento.setStatus(instance);
    }
}
