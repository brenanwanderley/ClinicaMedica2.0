/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.model;

import br.unicap.poo.clinicaMedica.model.exceptions.MedicoSemHorarioException;
import br.unicap.poo.clinicaMedica.model.exceptions.HorarioMedicoNaoEncontradoException;
import br.unicap.poo.clinicaMedica.model.exceptions.HorarioRepetidoException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Aluno
 */
public class HorarioMedico {
    private ArrayList<Horario> horarios;
    
    public HorarioMedico(Horario horario){
        this.horarios = new ArrayList<>();
        this.horarios.add(horario);
    }
    private HorarioMedico(HorarioMedico horarioMedico){
        this.horarios = new ArrayList();
        for(Horario item : horarioMedico.horarios){
            this.horarios.add(item.clonar());
        }
    }
    public List<Horario> getHorarios(){
        return horarios;
    }
    public void addHorario(Horario horario) throws HorarioRepetidoException{
        if(selecionar(horario.getCodigo())==null){
            horarios.add(horario.clonar(lastCode()+1));
        }else{
            throw new HorarioRepetidoException();
        }
    }
    public void removeHorario(Horario horario) throws HorarioMedicoNaoEncontradoException, MedicoSemHorarioException{
        int cont=0;
        
        if(horarios.size()==1){
            throw new MedicoSemHorarioException();
        }
        
        for(Horario item : horarios){
            if(item.getCodigo()==horario.getCodigo()){
                horarios.remove(cont);
                return;
            }else if(item.getCodigo()>horario.getCodigo()){
                throw new HorarioMedicoNaoEncontradoException();
            }
            cont++;
        }
        throw new HorarioMedicoNaoEncontradoException();

        
    }
    boolean horarioDisponivel(Date data){
        Calendar cal = Calendar.getInstance();
        cal.setTime(data);
        int diaSemana = cal.get(Calendar.DAY_OF_WEEK);
        int hora = cal.get(Calendar.HOUR_OF_DAY);
        
        for(Horario item : this.horarios){
            if(item.horarioValido(diaSemana, hora)){
                return true;
            }
        }
        
        return false;
    }
    public Horario selecionar(int codigo){        
        for(Horario item : horarios){
            if(item.getCodigo()==codigo){
                return item;
            }else if(item.getCodigo()>codigo){
                return null;
            }
        }
        return null;
    }
    public HorarioMedico clonar(){
        return new HorarioMedico(this);
    }
    private int lastCode(){
        return horarios.get(horarios.size()-1).getCodigo();
    }
}
