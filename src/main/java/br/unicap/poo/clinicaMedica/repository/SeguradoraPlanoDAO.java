/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.repository;

import br.unicap.poo.clinicaMedica.model.SeguradoraPlano;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Danilo
 */
public class SeguradoraPlanoDAO implements SeguradoraPlanoRepBridge{
    private ArrayList<SeguradoraPlano> dataBase;
    private static SeguradoraPlanoDAO instance;
    
    private SeguradoraPlanoDAO(){
        dataBase = new ArrayList();
    }
    public synchronized static SeguradoraPlanoDAO getInstance(){
        if(instance==null)
            instance = new SeguradoraPlanoDAO();
        return instance;
    } 
    @Override
    public boolean inserir(SeguradoraPlano item) {
        return dataBase.add(item.clonar(lastCode()+1));
    }

    @Override
    public boolean alterar(SeguradoraPlano item) {
        int cont=0;
        
        for(SeguradoraPlano data : dataBase){
            if(data.getCodigo()==item.getCodigo()){
                dataBase.set(cont, item);
                return true;
            }
            cont++;
        }
        return false;
    }

    @Override
    public boolean remover(SeguradoraPlano item) {
        int cont=0;
        for(SeguradoraPlano data : dataBase){
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
    public List<SeguradoraPlano> listar() {
        return dataBase;
    }

    @Override
    public SeguradoraPlano selecionar(int codigo) {
        int cont = 0;
        
        for(SeguradoraPlano data : dataBase){
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
