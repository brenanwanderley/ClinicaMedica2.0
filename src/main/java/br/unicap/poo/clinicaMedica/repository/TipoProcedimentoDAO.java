/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.repository;

import br.unicap.poo.clinicaMedica.model.TipoProcedimento;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Danilo
 */
public class TipoProcedimentoDAO implements TipoProcedimentoRepBridge{
    private ArrayList<TipoProcedimento> dataBase;
    private static TipoProcedimentoDAO instance;
    
    private TipoProcedimentoDAO(){
        dataBase = new ArrayList();
    }
    public synchronized static TipoProcedimentoDAO getInstance(){
        if(instance==null)
            instance = new TipoProcedimentoDAO();
        return instance;
    } 
    @Override
    public boolean inserir(TipoProcedimento item) {
        return dataBase.add(item.clonar(lastCode()+1));
    }

    @Override
    public boolean alterar(TipoProcedimento item) {
        int cont=0;
        
        for(TipoProcedimento data : dataBase){
            if(data.getCodigo()==item.getCodigo()){
                dataBase.set(cont, item);
                return true;
            }
            cont++;
        }
        return false;
    }

    @Override
    public boolean remover(TipoProcedimento item) {
        int cont=0;
        for(TipoProcedimento data : dataBase){
            if(item.getCodigo()==data.getCodigo()){
                dataBase.remove(cont);
                return true;
            }else if(item.getCodigo()<data.getCodigo()){
                return false;
            }
            cont++;
        }
        return false;
    }

    @Override
    public List<TipoProcedimento> listar() {
        return dataBase;
    }

    @Override
    public TipoProcedimento selecionar(int codigo) {
        int cont = 0;
        
        for(TipoProcedimento data : dataBase){
            if(data.getCodigo()==codigo){
                return dataBase.get(cont);
            }
            cont++;
        }
        return null;
    }
    private int lastCode(){
        if(dataBase.isEmpty()){
            return -1;
        }
        return dataBase.get(dataBase.size()-1).getCodigo();
    }
}
