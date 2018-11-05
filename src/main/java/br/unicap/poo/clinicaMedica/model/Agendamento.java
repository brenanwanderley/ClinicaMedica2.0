/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.model;
import br.unicap.poo.clinicaMedica.interpretors.DDMMYYYDateInterpretor;
import br.unicap.poo.clinicaMedica.interpretors.DateContext;
import br.unicap.poo.clinicaMedica.interpretors.DateInterpretor;
import br.unicap.poo.clinicaMedica.interpretors.JsonProcessor;
import br.unicap.poo.clinicaMedica.model.exceptions.AgendamentoException;
import br.unicap.poo.clinicaMedica.model.exceptions.DataInvalidaException;
import java.util.Date;
import java.util.Calendar;
/**
 *
 * @author aluno
 */
public abstract class Agendamento{
    private final int codigo;
    private Date data;
    private Status status;

    Agendamento() {
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
    public void setData(String data) throws DataInvalidaException{
        DateContext context = new DateContext(data, "/");
        DateInterpretor dateInterpretor = new DDMMYYYDateInterpretor(context);
        dateInterpretor.interpretar();
        setData(context.getData());
    }
    public void setData(Date data) throws DataInvalidaException {
        Calendar cal, cal2;
        cal2= Calendar.getInstance();
        cal = Calendar.getInstance();
        cal.setTime(data);
        
        if(cal.compareTo(cal2)<0){
            throw new DataInvalidaException("Data inválida");
        }
        
        this.data = data;
    }
    public Status getStatus() {
        return status;
    }
    public void setStatus(Status status) {
        this.status = status;
    }
    public int compareTo(Agendamento agendamento){
        if(this.codigo>codigo){
            return 1;
        }else if(this.codigo==codigo){
            return 0;
        }
        
        return -1;
    }
    protected void setAll(String jsonContent) throws AgendamentoException{
        JsonProcessor json = new JsonProcessor(jsonContent);
        setData(json.getJsonParam("data"));
    }
    public abstract Medico getMedico();
    public abstract Paciente getPaciente();
    public abstract Agendamento clonar(int codigo);
}
