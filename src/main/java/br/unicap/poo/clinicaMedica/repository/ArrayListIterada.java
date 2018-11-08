/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.repository;

import java.util.ArrayList;

/**
 *
 * @author Lucas Soares
 */
public class ArrayListIterada<T> extends ArrayList<T> implements Iterador<T>{
    int posicao;
    public ArrayListIterada(){
        super();
    }
    @Override
    public boolean hasNext(){
        T item = super.get(posicao);
        return item!=null;
    }
    @Override
    public T next(){
        T item = super.get(posicao);
        return item;
    }
}
