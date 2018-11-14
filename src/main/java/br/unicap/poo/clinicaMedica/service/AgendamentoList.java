/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.service;

import br.unicap.poo.clinicaMedica.model.Agendamento;
import br.unicap.poo.clinicaMedica.model.Medico;
import br.unicap.poo.clinicaMedica.iteradores.Iterador;
import br.unicap.poo.clinicaMedica.iteradores.ListIterador;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author Danilo
 */
class AgendamentoList {
    AgendamentoList(){
        
    }
    
    Iterador<Agendamento> verAgendamentos(Iterador<Agendamento> lista, Date data, Medico medico){
        Iterador<Agendamento> listarPorMedico = verAgendamentos(lista, medico);
        Iterador<Agendamento> listarPorDataEMedico = verAgendamentos(listarPorMedico, data);
        
        return listarPorDataEMedico;
    }
    Iterador<Agendamento> verAgendamentos(Iterador<Agendamento> lista, Medico medico){
        ArrayList<Agendamento> retorno = new ArrayList<>();
        Agendamento item;
        
        while(lista.hasNext()){
            item = lista.next();
            if(item.getMedico().equals(medico)){
                retorno.add(item);
                
            }
        }
        
        return new ListIterador<>(retorno);        
    }
    Iterador<Agendamento> verAgendamentos(Iterador<Agendamento> lista, Date data){
        ArrayList<Agendamento> retorno = new ArrayList<>();
        Calendar cal = new GregorianCalendar();
        Calendar calItem = new GregorianCalendar();
        int dia, mes, ano, diaItem, mesItem, anoItem;
        Agendamento item;
        
        cal.setTime(data);
        dia = cal.get(Calendar.DAY_OF_MONTH);
        mes = cal.get(Calendar.MONTH)+1;
        ano = cal.get(Calendar.YEAR);
        
        while(lista.hasNext()){
            item = lista.next();
            calItem.setTime(item.getData());
            diaItem=calItem.get(Calendar.DAY_OF_MONTH);
            mesItem=calItem.get(Calendar.MONTH)+1;
            anoItem=calItem.get(Calendar.YEAR);
                        
            if(diaItem==dia && mesItem==mes && anoItem==ano){
                retorno.add(item);
            }

        }
        
        return new ListIterador<>(retorno);        
    }
}
