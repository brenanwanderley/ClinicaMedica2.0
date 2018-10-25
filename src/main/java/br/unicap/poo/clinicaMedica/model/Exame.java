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
public class Exame extends Agendamento{
    private Consulta consulta;
    private TipoExame tipo;
    
    public Exame(Date data, Consulta consulta, TipoExame tipo) throws AgendamentoException{
        super(data);
        this.tipo=tipo;
        this.consulta=consulta;
    }
    private Exame(int codigo, Exame exame){
        super(codigo, exame);
        consulta = exame.consulta;
        tipo = exame.tipo;
    }
    public Consulta getConsulta() {
        return consulta;
    }
    public TipoExame getTipoExame() {
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
        return new Exame(codigo, this);
    }
}
