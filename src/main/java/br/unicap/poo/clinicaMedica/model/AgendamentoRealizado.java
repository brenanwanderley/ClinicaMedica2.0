/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.model;

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
            instance = new AgendamentoMarcado();
        }
        
        return instance;
    }
    public void reagendar(String data, Agendamento agendamento){
        throw new AgendamentoException("O agendamento já foi realizado");
    }
    public void realizar(Agendamento agendamento){
        this.agendamento.setStatus(AgendamentoRealizado.getInstance());
    }
}
