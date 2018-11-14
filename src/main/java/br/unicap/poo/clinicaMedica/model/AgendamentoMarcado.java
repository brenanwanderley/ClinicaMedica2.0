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
    public void reagendar(String data, Agendamento agendamento){
        this.agendamento.setData(data);
    }
    public void realizar(Agendamento agendamento){
        this.agendamento.setStatus(AgendamentoRealizado.getInstance());
    }
}
