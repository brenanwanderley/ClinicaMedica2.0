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
public class ExameBuilder{
    private Exame exame;
    public ExameBuilder(){
        exame = new Exame();
    }
    public ExameBuilder addData(String data) throws AgendamentoException{
        exame.setData(data);
        return this;
    }
    public ExameBuilder addConsulta(Consulta consulta){
        exame.setConsulta(consulta);
        return this;
    }
    public ExameBuilder addTipoExame(TipoExame tipoExame){
        exame.setTipoExame(tipoExame);
        return this;
    }
    public Exame build() throws AgendamentoException{
        if(exame.getConsulta()==null){
            throw new AgendamentoException("Exame sem consulta");
        }
        if(exame.getTipoExame()==null){
            throw new AgendamentoException("Exame sem tipo especificado");
        }
        
        return exame;
    }
}
