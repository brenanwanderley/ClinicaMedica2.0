/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.model;

import br.unicap.poo.clinicaMedica.model.exceptions.AgendamentoException;
import java.util.Date;

/**
 *
 * @author Brenan Wanderley
 */
public class ProcedimentoMedico extends Agendamento{
    public Consulta consulta;
    public TipoProcedimento tipo;

    public ProcedimentoMedico(Date data, Consulta consulta, TipoProcedimento tipo) throws AgendamentoException {
        super(data);
        this.consulta = consulta;
    }
    private ProcedimentoMedico(int codigo, ProcedimentoMedico procedimento){
        super(codigo, procedimento);
        this.consulta=procedimento.consulta;
        this.tipo = procedimento.tipo;
    }
    public Consulta getConsulta() {
        return consulta;
    }

    public TipoProcedimento getTipoProcedimento() {
        return tipo;
    }
    @Override
    public Medico getMedico(){
        return consulta.getMedico();
    }

    @Override
    public Paciente getPaciente() {
        return consulta.getPaciente();
    }
    @Override
    public Agendamento clonar(int codigo){
        return new ProcedimentoMedico(codigo, this);
    }
}
