/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.repository;

import br.unicap.poo.clinicaMedica.model.Especialidade;
import java.util.List;

/**
 *
 * @author Danilo
 */
public interface EspecialidadeRepBridge {
    public boolean inserir(Especialidade item);
    public boolean alterar(Especialidade item);
    public boolean remover(Especialidade item);
    public List<Especialidade> listar();
    public Especialidade selecionar(int codigo);
}
