/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.model;

import br.unicap.poo.clinicaMedica.model.exceptions.AgendamentoException;
import br.unicap.poo.clinicaMedica.model.exceptions.DataInvalidaException;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author Brenan Wanderley
 */
@ApplicationScoped
public class ProcedimentoMedico extends Agendamento{
    private Consulta consulta;
    private TipoProcedimento tipo;

    @JsonCreator
    public ProcedimentoMedico(@JsonProperty("data")String data, 
                              @JsonProperty("consulta") ConsultaDirector consultaDirector, 
                              @JsonProperty("tipo") TipoProcedimento tipo) throws AgendamentoException, ParseException{
        this.setData(data);
        this.consulta=consultaDirector.getConsulta();
        this.tipo=tipo;
        this.consulta.addProcedimento(getInstance());
    }
    @JsonIgnore
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
    public void setData(String data) throws DataInvalidaException, ParseException{
        DateFormat df = new SimpleDateFormat("dd/MM/yy", Locale.ENGLISH);
        this.setData(df.parse(data));
    }
    private ProcedimentoMedico getInstance(){
        return this;
    }
}
