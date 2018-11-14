/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.iteradores;

import java.util.List;
import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author aluno
 * @param <T> 
 */
@ApplicationScoped
public class ListIterador<T> implements Iterador<T>{
    private List<T> list;
    private int pos;
    
    public ListIterador(List<T> list){
        this.list=list;
    }
    
    @Override
    public boolean hasNext() {
        if(pos<list.size()){
            return true;
        }
        return false;
    }

    @Override
    public T next() {
        pos++;
        return list.get(pos);
    }
    
}
