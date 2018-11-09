/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.model;

import br.unicap.poo.clinicaMedica.model.exceptions.AgendamentoException;
import java.text.ParseException;
import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author Brenan Wanderley
 */
@ApplicationScoped
public class ProcedimentoMedico extends Agendamento{
    private Consulta consulta;
    private TipoProcedimento tipo;

    public ProcedimentoMedico(String data, Consulta consulta, TipoProcedimento tipo) throws AgendamentoException, ParseException{
        super(data);
        this.consulta=consulta;
        this.tipo=tipo;
    }
    private ProcedimentoMedico(int codigo, ProcedimentoMedico procedimento){
        super(codigo, procedimento);
        this.consulta=procedimento.consulta;
        this.tipo = procedimento.tipo;
    }
    public Consulta getConsulta() {
        return consulta;
    }
    void setConsulta(Consulta consulta){
        this.consulta=consulta;
    }
    public TipoProcedimento getTipoProcedimento() {
        return tipo;
    }
    void setTipoProcedimento(TipoProcedimento tipo){
        this.tipo=tipo;
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
