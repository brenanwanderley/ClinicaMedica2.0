/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.repository;

import br.unicap.poo.clinicaMedica.model.Exame;
import java.util.List;

/**
 *
 * @author Danilo
 */
public interface ExameRepBridge {
    public boolean inserir(Exame item);
    public boolean alterar(Exame item);
    public boolean remover(Exame item);
    public List<Exame> listar();
    public Exame selecionar(int codigo); 
}
