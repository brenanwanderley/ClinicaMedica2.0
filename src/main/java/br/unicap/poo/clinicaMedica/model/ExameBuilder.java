/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.model;

import br.unicap.poo.clinicaMedica.model.exceptions.AgendamentoException;


/**
 *
 * @author Lucas Soares
 */
public class ExameBuilder extends AgendamentoBuilder{
    public ExameBuilder(){
        this.agendamento = new Exame();
    }
    public ExameBuilder addConsulta(Consulta consulta){
        Exame item = (Exame)this.agendamento;
        item.setConsulta(consulta);
        return this;
    }
    public ExameBuilder addTipoExame(TipoExame tipoExame){
        Exame item = (Exame)this.agendamento;
        item.setTipoExame(tipoExame);
        return this;
    }
    @Override
    public Agendamento build() throws AgendamentoException{
        Exame item = (Exame)this.agendamento;
        if(item.getConsulta()==null){
            throw new AgendamentoException("Exame sem consulta");
        }
        if(item.getTipoExame()==null){
            throw new AgendamentoException("Exame sem tipo especificado");
        }
        
        return item;
    }
}
