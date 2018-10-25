/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.repository;

import br.unicap.poo.clinicaMedica.model.SeguradoraPlano;
import java.util.List;

/**
 *
 * @author Danilo
 */
public interface SeguradoraPlanoRepBridge {
    public boolean inserir(SeguradoraPlano item);
    public boolean alterar(SeguradoraPlano item);
    public boolean remover(SeguradoraPlano item);
    public List<SeguradoraPlano> listar();
    public SeguradoraPlano selecionar(int codigo);
}
