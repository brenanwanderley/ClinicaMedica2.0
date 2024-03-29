/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.repository;

import br.unicap.poo.clinicaMedica.iteradores.Iterador;
import br.unicap.poo.clinicaMedica.model.Medico;
/**
 *
 * @author Danilo
 */
public interface MedicoRepBridge {
    public boolean inserir(Medico item);
    public boolean alterar(Medico item);
    public boolean remover(Medico item);
    public Iterador<Medico> listar();
    public Medico selecionar(int codigo);
}
