/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.model;

import br.unicap.poo.clinicaMedica.model.exceptions.AgendamentoException;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;
import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author Brenan Wanderley
 */
@ApplicationScoped
public class Exame extends Agendamento{
    private Consulta consulta;
    private TipoExame tipo;
    
    @JsonCreator
    public Exame(@JsonProperty("data") Date data, 
                @JsonProperty("consulta") Consulta consulta, 
                @JsonProperty("tipo") TipoExame tipo) throws AgendamentoException{
        super(data);
        this.tipo=tipo;
        this.consulta=consulta;
        consulta.addExame(this);
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
    public void setAll(Exame exame, TipoExame tipoExameRef){
        super.setAll(exame);
        this.tipo=tipoExameRef;
    }
}
