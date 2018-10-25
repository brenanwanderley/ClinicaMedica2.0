/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.service;

import br.unicap.poo.clinicaMedica.model.Agendamento;
import br.unicap.poo.clinicaMedica.model.Medico;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 *
 * @author Danilo
 */
class AgendamentoList {
    AgendamentoList(){
        
    }
    
    List<Agendamento> verAgendamentos(List<Agendamento> lista, Date data, Medico medico){
        List<Agendamento> listarPorMedico = verAgendamentos(lista, medico);
        List<Agendamento> listarPorDataEMedico = verAgendamentos(listarPorMedico, data);
        
        return listarPorDataEMedico;
    }
    List<Agendamento> verAgendamentos(List<Agendamento> lista, Medico medico){
        List<Agendamento> retorno = new ArrayList<>();
        
        for(Agendamento item : lista){
            if(item.getMedico().equals(medico)){
                retorno.add(item);
            }
        }
        
        return retorno;        
    }
    List<Agendamento> verAgendamentos(List<Agendamento> lista, Date data){
        List<Agendamento> retorno = new ArrayList<>();
        Calendar cal = new GregorianCalendar();
        Calendar calItem = new GregorianCalendar();
        int dia, mes, ano, diaItem, mesItem, anoItem;
        
        cal.setTime(data);
        dia = cal.get(Calendar.DAY_OF_MONTH);
        mes = cal.get(Calendar.MONTH)+1;
        ano = cal.get(Calendar.YEAR);
        
        for(Agendamento item : lista){
            calItem.setTime(item.getData());
            diaItem=calItem.get(Calendar.DAY_OF_MONTH);
            mesItem=calItem.get(Calendar.MONTH)+1;
            anoItem=calItem.get(Calendar.YEAR);
                        
            if(diaItem==dia && mesItem==mes && anoItem==ano){
                retorno.add(item);
            }

        }
        
        return retorno;        
    }
}
