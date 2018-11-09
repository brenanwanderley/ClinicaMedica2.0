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
public class Exame extends Agendamento{
    private Consulta consulta;
    private TipoExame tipo;
    
    public Exame(String data, Consulta consulta, TipoExame tipo) throws AgendamentoException, ParseException{
        super(data);
        this.consulta=consulta;
        this.tipo=tipo;
    }
    private Exame(int codigo, Exame exame){
        super(codigo, exame);
        consulta = exame.consulta;
        tipo = exame.tipo;
    }

    public Consulta getConsulta() {
        return consulta;
    }
    void setConsulta(Consulta consulta){
        this.consulta=consulta;
    }
    public TipoExame getTipoExame() {
        return tipo;
    }
    void setTipoExame(TipoExame tipoExame){
       this.tipo=tipoExame;
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
        return new Exame(codigo, this);
    }
}
