/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.repository;

import br.unicap.poo.clinicaMedica.iteradores.Iterador;
import br.unicap.poo.clinicaMedica.model.TipoProcedimento;
/**
 *
 * @author Danilo
 */
public interface TipoProcedimentoRepBridge {
    public boolean inserir(TipoProcedimento item);
    public boolean alterar(TipoProcedimento item);
    public boolean remover(TipoProcedimento item);
    public Iterador<TipoProcedimento> listar();
    public TipoProcedimento selecionar(int codigo);
}
