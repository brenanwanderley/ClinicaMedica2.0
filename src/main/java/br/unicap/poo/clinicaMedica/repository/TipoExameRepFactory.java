/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.repository;

import java.io.IOException;

/**
 *
 * @author Danilo
 */
public abstract class TipoExameRepFactory {
    public abstract TipoExameRepBridge getInstance();
    public abstract void setConfig(TipoExameRepEnum tipoExameEnum) throws IOException;    

}
