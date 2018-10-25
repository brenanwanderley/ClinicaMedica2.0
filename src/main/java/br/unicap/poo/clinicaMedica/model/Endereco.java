/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.model;

import br.unicap.poo.clinicaMedica.model.exceptions.NumeroInvalidoException;
import br.unicap.poo.clinicaMedica.model.exceptions.EnderecoException;
import br.unicap.poo.clinicaMedica.model.exceptions.CepInvalidoException;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author aluno
 */
public class Endereco {
    private String cep;
    private int numero;
    private String complemento;

    @JsonCreator
    public Endereco(@JsonProperty("cep") String cep, @JsonProperty("numero")int numero, @JsonProperty("complemento")String complemento) throws EnderecoException{
        setCep(cep);
        setNumero(numero);
        this.complemento=complemento;
    }
    public Endereco(){
        
    }
    private Endereco(Endereco endereco){
        this.cep=endereco.cep;
        this.numero=endereco.numero;
        this.complemento=endereco.complemento;
    }
    public String getCep() {
        return cep;
    }

    public void setCep(String cep) throws CepInvalidoException {
        int cepLen = cep.length();
        if(cepLen<8 || cepLen>8){
            throw new CepInvalidoException("Número insucifiente");
        }
        for(int i=0; i<8; i++){
            if(!Character.isDigit(cep.charAt(0))){
                throw new CepInvalidoException("Caracteres inválidos para um CEP");
            }
        }
        this.cep=cep;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) throws NumeroInvalidoException {
        if(numero<0){
            throw new NumeroInvalidoException();
        }
        this.numero=numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
    
    public boolean enderecoCompleto(){
        return cep!=null;
    }
    public Endereco clonar(){
        return new Endereco(this);
    }
    public void setAll(Endereco endereco){
        this.cep=endereco.cep;
        this.complemento=endereco.complemento;
        this.numero=endereco.numero;
    }
    
}
