/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.model;

import br.unicap.poo.clinicaMedica.model.exceptions.AgendamentoException;
import br.unicap.poo.clinicaMedica.model.exceptions.DataInvalidaException;

/**
 *
 * @author Lucas Soares
 */
public class ProcedimentoMedicoBuilder{
    private ProcedimentoMedico procedimentoMedico;
    public ProcedimentoMedicoBuilder(){
        procedimentoMedico = new ProcedimentoMedico();
    }
    public ProcedimentoMedicoBuilder addData(String data) throws DataInvalidaException{
        procedimentoMedico.setData(data);
        return this;
    }
    public ProcedimentoMedicoBuilder addConsulta(Consulta consulta){
        procedimentoMedico.setConsulta(consulta);
        return this;
    }
    public ProcedimentoMedicoBuilder addTipoProcedimento(TipoProcedimento tipoProcedimento){
        procedimentoMedico.setTipoProcedimento(tipoProcedimento);
        return this;
    }
    public ProcedimentoMedico build() throws AgendamentoException{
        if(procedimentoMedico.getConsulta()==null){
            throw new AgendamentoException("Procedimento médico sem consulta");
        }
        if(procedimentoMedico.getTipoProcedimento()==null){
            throw new AgendamentoException("Procedimento médico sem tipo especificado");
        }
        
        return procedimentoMedico;
    }
}