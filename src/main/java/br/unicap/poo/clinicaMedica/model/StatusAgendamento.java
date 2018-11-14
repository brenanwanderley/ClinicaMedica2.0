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
public interface StatusAgendamento {
    public void reagendar(String data, Agendamento agendamento) throws AgendamentoException, ParseException;
    public void realizar(Agendamento agendamento) throws AgendamentoException;
}
