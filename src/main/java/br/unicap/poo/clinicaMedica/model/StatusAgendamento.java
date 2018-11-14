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
public interface StatusAgendamento {
    public void reagendar(String data, Agendamento agendamento);
    public void realizar(Agendamento agendamento);
}
