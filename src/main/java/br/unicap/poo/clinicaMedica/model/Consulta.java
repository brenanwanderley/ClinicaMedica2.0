/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.model;

import br.unicap.poo.clinicaMedica.model.exceptions.ConsultaException;
import br.unicap.poo.clinicaMedica.model.exceptions.DataInvalidaException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author Brenan Wanderley
 */
@ApplicationScoped
public class Consulta extends Agendamento{
    private Medico medico;
    private List<Exame> exames;
    private List<ProcedimentoMedico> procedimentos;
    private Paciente paciente;
    
    private Consulta(int codigo, Consulta consulta){
        super(codigo, consulta);
        this.medico=consulta.medico;
        this.exames= new ArrayList();
        for(Exame item : consulta.exames){
            exames.add(item);
        }
        this.procedimentos = new ArrayList();
        for(ProcedimentoMedico item : consulta.procedimentos){
            procedimentos.add(item);
        }
        this.paciente=consulta.paciente;
    }
    Consulta(){
        super();
        exames = new ArrayList();
        procedimentos = new ArrayList();
    }

    @Override
    public Medico getMedico() {
        return medico;
    }
    void setMedico(Medico medico) throws ConsultaException{
        if(medico==null){
            medico=null;
            return;
        }
        if(medico.horarioDisponivel(super.getData())){
            if(medico.atendePlanoSaude(paciente.getPlanoDeSaude().getSeguradoraPlano())){
                this.medico=medico;
            }else{
                throw new ConsultaException("O médico não atende ao plano de saúde do paciente");
            }
        }else{
            throw new ConsultaException("O médico não tem horário disponível");
        }
    }

    public List<Exame> getExames() {
        return exames;
    }

    public List<ProcedimentoMedico> getProcedimentos() {
        return procedimentos;
    }
    @Override
    public Paciente getPaciente() {
        return paciente;
    }
    void setPaciente(Paciente paciente){
        this.paciente=paciente;
    }
    public void addExame(Exame exame){
        exames.add(exame);
    }
    public void addProcedimento(ProcedimentoMedico procedimento){
        procedimentos.add(procedimento);
    }
    public void removeExame(Exame exame){
        int cont=0;
        for(Exame item : exames){
            if(item.getCodigo()==exame.getCodigo()){
                exames.remove(cont);
                return;
            }else if(item.getCodigo()>exame.getCodigo()){
                return;
            }
            cont++;
        }
    }
    public void removeProcedimento(ProcedimentoMedico procedimento){
        int cont=0;
        for(ProcedimentoMedico item : procedimentos){
            if(item.getCodigo()==procedimento.getCodigo()){
                procedimentos.remove(cont);
                return;
            }else if(item.getCodigo()>procedimento.getCodigo()){
                return;
            }
            cont++;
        }
    }
    @Override
    public Agendamento clonar(int codigo){
        return new Consulta(codigo, this);
    }
    @Override
    void setData(String data) throws DataInvalidaException, ParseException{
        DateFormat df = new SimpleDateFormat("dd/MM/yy hh:mm", Locale.ENGLISH);
        this.setData(df.parse(data));
    }
}
