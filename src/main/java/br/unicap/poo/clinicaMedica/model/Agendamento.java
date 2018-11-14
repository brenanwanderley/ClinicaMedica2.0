/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.model;
import br.unicap.poo.clinicaMedica.model.exceptions.AgendamentoException;
import br.unicap.poo.clinicaMedica.model.exceptions.DataInvalidaException;
import java.text.ParseException;
import java.util.Date;
import java.util.Calendar;
/**
 *
 * @author aluno
 */
public abstract class Agendamento{
    private final int codigo;
    private Date data;
    private StatusAgendamento status;

    public Agendamento(Date data) throws AgendamentoException, ParseException {
        this.setData(data);
        this.codigo=0;
    }
    protected Agendamento(){
        this.codigo=0;
    }
    protected Agendamento(int codigo, Agendamento agendamento){
        this.codigo=codigo;
        this.data=agendamento.data;
        this.status=agendamento.status;
    }
    public int getCodigo() {
        return codigo;
    }
    public Date getData() {
        return data;
    }
    public void setData(Date data) throws DataInvalidaException {
        Calendar cal = Calendar.getInstance();
        
        if(data.compareTo(cal.getTime())<0){
            throw new DataInvalidaException("Data inválida");
        }
        
        this.data = data;
    }
    public int compareTo(Agendamento agendamento){
        if(this.codigo>codigo){
            return 1;
        }else if(this.codigo==codigo){
            return 0;
        }
        
        return -1;
    }
    void setStatus(StatusAgendamento status){
        this.status=status;
    }
    public void realizar(){
        this.status.realizar(this);
    }
    public void reagendar(String data){
        this.status.reagendar(data, this);
    }
    public abstract Medico getMedico();
    public abstract Paciente getPaciente();
    public abstract Agendamento clonar(int codigo);
    abstract void setData(String data) throws DataInvalidaException, ParseException;
}
