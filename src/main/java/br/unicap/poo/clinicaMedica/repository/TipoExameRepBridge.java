/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.repository;

import br.unicap.poo.clinicaMedica.model.TipoExame;
import java.util.List;

/**
 *
 * @author Danilo
 */
public interface TipoExameRepBridge {
    public boolean inserir(TipoExame item);
    public boolean alterar(TipoExame item);
    public boolean remover(TipoExame item);
    public List<TipoExame> listar();
    public TipoExame selecionar(int codigo);
}
