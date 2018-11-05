/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.model;

import br.unicap.poo.clinicaMedica.model.exceptions.AgendamentoException;
import br.unicap.poo.clinicaMedica.model.exceptions.DataInvalidaException;
import java.util.Date;

/**
 *
 * @author Lucas Soares
 */
public abstract class AgendamentoBuilder {
    protected Agendamento agendamento;
    
    public AgendamentoBuilder(){
        
    }
    public AgendamentoBuilder addData(Date data) throws DataInvalidaException{
        agendamento.setData(data);
        return this;
    }
    public abstract Agendamento build() throws AgendamentoException;
}
