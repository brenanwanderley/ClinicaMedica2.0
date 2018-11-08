/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.service;
import br.unicap.poo.clinicaMedica.model.TipoProcedimento;
import br.unicap.poo.clinicaMedica.repository.Iterador;
import br.unicap.poo.clinicaMedica.repository.TipoProcedimentoRepBridge;
import br.unicap.poo.clinicaMedica.repository.TipoProcedimentoConcreteRepFactory;
import br.unicap.poo.clinicaMedica.repository.TipoProcedimentoRepFactory;
/**
 *
 * @author Danilo
 */
public class TipoProcedimentoService {
    private TipoProcedimentoRepBridge tipoProcedimentos;
    
    public TipoProcedimentoService(){
        TipoProcedimentoRepFactory instance = new TipoProcedimentoConcreteRepFactory();
        tipoProcedimentos = instance.getInstance();
    }

    public void cadastrarTipoProcedimento(TipoProcedimento item){
        tipoProcedimentos.inserir(item);
    }
    public void alterarTipoProcedimento(TipoProcedimento item){
        tipoProcedimentos.alterar(item);
    }
    public void removerTipoProcedimento(TipoProcedimento item){
        tipoProcedimentos.remover(item);
    }
    public Iterador<TipoProcedimento> listar(){
        Iterador<TipoProcedimento> listaTiposProcedimentos = tipoProcedimentos.listar();
        
        return listaTiposProcedimentos;
    }
    public TipoProcedimento selecionar(int codigo){
        TipoProcedimento selecao = tipoProcedimentos.selecionar(codigo);
        
        return selecao;        
    }

}
