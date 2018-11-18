/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.iteradores;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 *
 * @author Lucas Soares
 */
public abstract class Iterador<T> {

    public String toJson() throws JsonProcessingException{
        StringBuilder sb = new StringBuilder();
        ObjectMapper mapper = new ObjectMapper();
        String jsonResult;
        T item;
        
        if(!this.isEmpty()){
            sb.append("[");
            while(this.hasNext()){
                item = this.next();
                jsonResult = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(item);
                sb.append(jsonResult);
                sb.append(",");
            }
            sb.replace(sb.length()-1, sb.length(), " ");
            sb.append("]");
            return sb.toString();
        }
        return "";
    }
    
    public abstract boolean hasNext();
    public abstract T next();
    public abstract boolean isEmpty();
    
}
