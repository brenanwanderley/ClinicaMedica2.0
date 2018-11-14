/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.repository;

import br.unicap.poo.clinicaMedica.iteradores.Iterador;
import br.unicap.poo.clinicaMedica.model.Paciente;
/**
 *
 * @author Danilo
 */
public interface PacienteRepBridge {
    public boolean inserir(Paciente item);
    public boolean alterar(Paciente item);
    public boolean remover(Paciente item);
    public Iterador<Paciente> listar();
    public Paciente selecionar(String cpf); 
}
