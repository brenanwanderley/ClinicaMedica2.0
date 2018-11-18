/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.iteradores;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;

/**
 *
 * @author aluno
 * @param <T> 
 */
public class ListIterador<T> extends Iterador<T>{
    private List<T> list;
    private int pos;
    
    public ListIterador(List<T> list){
        this.list=list;
        this.pos=-1;
    }
    
    @Override
    public boolean hasNext() {
        if((pos+1)<list.size()){
            return true;
        }
        return false;
    }

    @Override
    public T next() {
        pos++;
        return list.get(pos);
    }
    public boolean isEmpty(){
        return list.isEmpty();
    }
}
