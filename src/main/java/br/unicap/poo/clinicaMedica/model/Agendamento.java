/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.model;
import br.unicap.poo.clinicaMedica.model.exceptions.AgendamentoException;
import br.unicap.poo.clinicaMedica.model.exceptions.DataInvalidaException;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Calendar;
/**
 *
 * @author aluno
 */
public abstract class Agendamento{
    private int codigo;
    private Date data;
    private StatusAgendamento status;

    public Agendamento(Date data) throws AgendamentoException, ParseException {
        this.setData(data);
        this.codigo=0;
    }
    protected Agendamento(){
        this.codigo=0;
        this.status=AgendamentoMarcado.getInstance();
    }
    protected Agendamento(int codigo, Agendamento agendamento){
        this.codigo=codigo;
        this.data=agendamento.data;
        this.status=agendamento.status;
    }
    public int getCodigo() {
        return codigo;
    }
    void setCodigo(int codigo){
        this.codigo=codigo;
    }
    @JsonIgnore
    public Date getData() {
        return data;
    }
    @JsonGetter("data")
    public String getDataString(){
        if(this.data!=null){
            Calendar calendar = Calendar.getInstance(); 
            calendar.setTime(this.data);
            DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT);
            return df.format(calendar.getTime());
        }
        return "00/00/00";       
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
    public void realizar() throws AgendamentoException{
        this.status.realizar(this);
    }
    public void reagendar(String data) throws AgendamentoException, ParseException{
        this.status.reagendar(data, this);
    }
    public abstract Medico getMedico();
    public abstract Paciente getPaciente();
    abstract void setData(String data) throws DataInvalidaException, ParseException;
}
